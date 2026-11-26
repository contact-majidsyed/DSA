# Two Sum

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **HashMap**

## Problem

Return the indices of two distinct elements whose sum is target. Assume exactly one answer exists.

## ASCII walkthrough

```text
[2, 7, 11, 15], target = 9
 2 -> need 7 -> store 2:index 0
 7 -> need 2 -> found index 0
 answer = [0, 1]
```

## How the code works

Look up the complement before storing the current value. This prevents reusing the same element. The map remembers indices, not just whether a number exists.

[Java solution](Solution.java)

## Complexity

Time O(n) expected; auxiliary space O(n).

## Edge cases and assumptions

Duplicate values such as [3,3]; negative numbers; complement overflow.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
