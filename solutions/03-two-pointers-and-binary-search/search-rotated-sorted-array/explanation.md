# Search in Rotated Sorted Array

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Modified binary search**

## Problem

Find target in a rotated ascending array of distinct integers, returning -1 if absent.

## ASCII walkthrough

```text
[4,5,6,7,0,1,2], target=0
 L     M     R
left half [4..7] sorted, excludes 0
search right half [0,1,2] -> index 4
```

## How the code works

At least one half is sorted. Determine which one, then compare target against that half's endpoints to choose the remaining search interval. The distinct-value assumption makes this decision unambiguous.

[Java solution](Solution.java)

## Complexity

Time O(log n); auxiliary space O(1).

## Edge cases and assumptions

Empty array; unrotated array; one element; absent target; duplicates not supported.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
