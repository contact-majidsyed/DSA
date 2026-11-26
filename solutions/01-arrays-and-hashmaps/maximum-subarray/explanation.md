# Maximum Subarray

[Quick recall](trick.md)

[Question and examples](question.md) | [Java solution](Solution.java)

Difficulty: **MEDIUM** | Pattern: **Kadane dynamic programming**

## What are we trying to find?

Find the largest sum from a **continuous stretch** of the array. You cannot skip elements inside that stretch, and you must choose at least one element.

```text
Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
                   +---------+
Choose:            [4, -1, 2, 1]
Sum:                4 - 1 + 2 + 1 = 6
```

The method returns **6**, not the selected elements. The highlighted stretches below explain the choices; the actual code stores only sums, not lists or start/end indices.

## The high-level idea: keep going or start fresh

Walk through the array once, from left to right. At each new number, ask:

> Is it better to add this number to the stretch I was carrying, or start a new stretch with just this number?

There are only two choices because a continuous subarray ending here either starts here or continues from the previous position.

```text
                         New number x
                              |
                +-------------+-------------+
                |                           |
         START FRESH                     EXTEND
         Take x alone             Take old current + x
                |                           |
                +-------------+-------------+
                              |
                      Keep the larger sum
                              |
                      This is new current
                              |
                Update best if current is larger
```

If the old sum is negative, carrying it makes the new number worse, so start fresh. If it is positive, carrying it helps, so extend. If it is zero, both choices have the same sum.

**A negative number does not automatically mean restart.** What matters is the sum you were carrying before that number.

## What do `current` and `best` mean?

- **`current`:** the largest sum of a nonempty subarray that **must end at the position we are visiting**. It can rise or fall as we move.
- **`best`:** the largest sum we have found **anywhere so far**. It remembers an earlier winner even if `current` gets worse.

For example, after visiting `-5` near the end:

```text
current stretch: [4, -1, 2, 1, -5] -> sum 1
best so far:     [4, -1, 2, 1]     -> sum 6

current = 1     best = 6
```

These variables answer different questions. Returning `current` at the end would be wrong for this example; we return `best`.

## Connect the idea to your exact code

```java
long current = nums[0], best = nums[0];

for (int i = 1; i < nums.length; i++) {
    current = Math.max(nums[i], current + nums[i]);
    best = Math.max(best, current);
}
return best;
```

The first element gives us our first valid, nonempty subarray. Start the loop at index 1 because index 0 is already handled.

Read the two updates like this:

```text
current = Math.max(nums[i], current + nums[i]);
                   ------  -----------------
                   restart      extend
                           |
                  choose the larger sum

best = Math.max(best, current);
                ----  -------
             old record  new candidate
```

Java evaluates the right side before assigning the left side. Therefore, `current + nums[i]` uses the **old** current. The next line uses the **new** current.

## Debug walkthrough: every movement

```text
Index:   0   1   2   3   4   5   6   7   8
Value:  -2   1  -3   4  -1   2   1  -5   4
         ^
Initialize: current = -2, best = -2
```

### Move to index 1: value 1

```text
Old current = -2
Restart:  1
Extend:  -2 + 1 = -1
Choose:   1 -> START FRESH

[-2]   [1]   -3   4   -1   2   1   -5   4
 drop   ^
current = 1, best = max(-2, 1) = 1
```

The old negative sum would only reduce the new number. Leave it behind.

### Move to index 2: value -3

```text
Old current = 1
Restart: -3
Extend:   1 + (-3) = -2
Choose:  -2 -> EXTEND

-2   [1, -3]   4   -1   2   1   -5   4
          ^
current = -2, best = max(1, -2) = 1
```

Both choices are negative, but `-2` is larger than `-3`. We must include this position when calculating `current`. The earlier answer `[1]` remains remembered by `best`.

### Move to index 3: value 4

```text
Old current = -2
Restart: 4
Extend: -2 + 4 = 2
Choose: 4 -> START FRESH

-2   [1, -3]   [4]   -1   2   1   -5   4
       drop     ^
current = 4, best = max(1, 4) = 4
```

This is where the winning stretch begins. We do not know it will win yet; we only know that starting at 4 is better than carrying a negative sum.

### Move through indices 4, 5, and 6: extend the winner

```text
Index 4, value -1:
  restart = -1, extend = 4 + (-1) = 3
  choose extend: [4, -1]
  current = 3, best = 4

Index 5, value 2:
  restart = 2, extend = 3 + 2 = 5
  choose extend: [4, -1, 2]
  current = 5, best = 5

Index 6, value 1:
  restart = 1, extend = 5 + 1 = 6
  choose extend: [4, -1, 2, 1]
  current = 6, best = 6
```

Notice that we kept `-1` inside the stretch. The positive sum before it made extending worthwhile, and keeping the stretch continuous let us reach the later `2` and `1`.

### Move to index 7: value -5

```text
Old current = 6
Restart: -5
Extend:   6 + (-5) = 1
Choose:   1 -> EXTEND

current stretch: [4, -1, 2, 1, -5] -> 1
best stretch:    [4, -1, 2, 1]     -> 6

current = 1, best = 6
```

We do not erase the record of 6 just because the moving candidate became worse.

### Move to index 8: value 4

```text
Old current = 1
Restart: 4
Extend:  1 + 4 = 5
Choose:  5 -> EXTEND

current stretch: [4, -1, 2, 1, -5, 4] -> 5
best stretch:    [4, -1, 2, 1]        -> 6

End of array: current = 5, best = 6
RETURN best -> 6
```

## The whole trace in one view

```text
i  value  old current  restart  extend  decision    new current  best
0     -2       --         --      --    initialize      -2       -2
1      1       -2          1      -1    restart          1        1
2     -3        1         -3      -2    extend          -2        1
3      4       -2          4       2    restart          4        4
4     -1        4         -1       3    extend           3        4
5      2        3          2       5    extend           5        5
6      1        5          1       6    extend           6        6
7     -5        6         -5       1    extend           1        6
8      4        1          4       5    extend           5        6
```

## Print your own debug trace

Paste this method inside a Java class. It follows the same calculation as the solution but names the two choices and prints them. Call it with `debugMaxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});` from a `main` method or your IDE.

```java
public static long debugMaxSubArray(int[] nums) {
    if (nums.length == 0) {
        throw new IllegalArgumentException("Empty input");
    }

    long current = nums[0];
    long best = nums[0];
    System.out.printf("i=0 value=%d initialize current=%d best=%d%n",
            nums[0], current, best);

    for (int i = 1; i < nums.length; i++) {
        long oldCurrent = current;
        long restart = nums[i];
        long extend = oldCurrent + nums[i];
        String decision = restart > extend ? "restart"
                : restart < extend ? "extend" : "tie: either";

        current = Math.max(restart, extend);
        best = Math.max(best, current);

        System.out.printf(
                "i=%d value=%d old=%d restart=%d extend=%d -> %s; current=%d best=%d%n",
                i, nums[i], oldCurrent, restart, extend, decision, current, best);
    }
    System.out.println("Answer = " + best);
    return best;
}
```

In a debugger, place a breakpoint on the `current = Math.max(...)` line. Watch `i`, `nums[i]`, `current`, and `best`. Step over once to see the new current, then once more to see whether best changes. There is one moving index; no second pointer or nested search is needed.

## Why does this find the answer?

Every subarray ending at index `i` either contains only `nums[i]`, or extends a subarray ending at `i - 1`. Among all stretches ending at `i - 1`, the one with the largest sum is the best one to extend: adding the same new number preserves their ordering.

So those two choices are sufficient to find the best stretch ending at each position. Every possible winning subarray ends somewhere. Taking the largest of all these ending-position answers gives the overall answer.

## Important edge cases

**All numbers are negative:** choose the least negative element, not zero.

```text
Input: [-5, -2, -7]
start: current=-5, best=-5
at -2: max(-2, -5-2) = -2; best=-2
at -7: max(-7, -2-7) = -7; best=-2
Answer: -2
```

This is why initialization uses the first element. Initializing `best` to zero would incorrectly allow an empty subarray.

**One element:** `[7]` returns 7; the loop does not run.

**Zero-sum ties:** for `[0,2]`, restarting at 2 or extending `[0,2]` gives the same sum. The code only returns the sum, so it does not need to choose between tied stretches.

**Empty input:** rejected because the problem requires a nonempty subarray. `long` sums avoid ordinary `int` addition overflow. The input array is not modified.

## Complexity

Time **O(n)**: visit each element once. Auxiliary space **O(1)**: keep only the index and two sums. The diagrams do not represent extra arrays allocated by the solution.

## Check your understanding

Trace `[5, -2, 3, -10, 4]` before reading the answer:

1. Does seeing `-2` make us restart?
2. What happens when we reach the final `4`?
3. Is the final answer `current` or `best`?

<details>
<summary>Reveal the trace</summary>

```text
value:    5  -2   3  -10   4
current:  5   3   6   -4   4
best:     5   5   6    6   6
```

We extend at `-2`. At the final `4`, we restart because the previous current is negative. The answer is `best = 6`, from `[5,-2,3]`; the final current is only 4.

</details>
