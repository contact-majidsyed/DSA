# Container With Most Water

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Greedy two pointers**

## Problem

Return maximum water area between two nonnegative heights.

## ASCII walkthrough

```text
[1,8,6,2,5,4,8,3,7]
   L             R
min(8,7) * (8-1) = 49
move the shorter endpoint inward
```

## How the code works

Area is limited by the shorter line. Keeping that line while reducing width cannot improve the area, so discard it. Use long multiplication to avoid int area overflow.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Fewer than two lines returns zero; all zeros; equal heights.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
