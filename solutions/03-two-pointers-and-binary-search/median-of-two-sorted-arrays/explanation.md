# Median of Two Sorted Arrays

Difficulty: **HIGH** | Pattern: **Binary search partition**

## Problem

Return the median of two ascending arrays. At least one array must be nonempty.

## ASCII walkthrough

```text
A: [2 | ]
B: [1 | 3]
left size = 2, right size = 1
max(left)=2 <= min(right)=3
odd total -> median = 2
```

## How the code works

Binary-search the smaller array's cut i. Choose j so the combined left side has half the values, rounded up. A valid cut has both left boundary values no larger than the opposite right boundary. Move i left if A contributes too large a left value, otherwise right. Sentinels handle empty partitions.

[Java solution](Solution.java)

## Complexity

Time O(log(min(m,n) + 1)); auxiliary space O(1).

## Edge cases and assumptions

One array empty; odd/even totals; duplicates; extreme int values; both empty rejected.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
