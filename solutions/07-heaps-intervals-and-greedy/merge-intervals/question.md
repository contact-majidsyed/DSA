# Merge Intervals

Difficulty: **MEDIUM**

## Question

Merge overlapping closed intervals [start,end]. Touching endpoints overlap. The input outer array is sorted in place.

## Input

Closed intervals [start,end] with start <= end.

## Output

Non-overlapping merged intervals covering the same values.

## Example 1

```text
Input: intervals = [[1,3],[2,6],[8,10]]
Output: [[1,6],[8,10]]
```

The first two intervals overlap.

## Example 2

```text
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
```

Closed intervals overlap at their shared endpoint 4.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
