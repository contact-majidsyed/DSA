# Merge Intervals

Difficulty: **MEDIUM** | Pattern: **Sorting**

## Problem

Merge overlapping closed intervals [start,end]. Touching endpoints overlap. The input outer array is sorted in place.

## ASCII walkthrough

```text
[1----3]
   [2-------6]      [8--10]
merge first two -> [1-------6] [8--10]
```

## How the code works

Sort by start. A new interval either begins after the last result ends, or overlaps that result. Extend an overlapping result to the larger end. Copy input rows when starting groups so merged endpoints do not overwrite original rows.

[Java solution](Solution.java)

## Complexity

Time O(n log n); auxiliary space O(n) including object-array sorting workspace; output O(n).

## Edge cases and assumptions

Empty input; nested intervals; touching endpoints; valid start <= end assumed; outer input order changes.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
