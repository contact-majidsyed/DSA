# Meeting Rooms II

Difficulty: **MEDIUM**

## Question

Return the minimum rooms needed for meetings [start,end), with start < end. A room ending at a new meeting's start is free. Input is sorted in place.

## Input

Meeting intervals [start,end) with start < end.

## Output

The minimum number of rooms required to host all meetings.

## Example 1

```text
Input: intervals = [[9,10],[9,12],[10,11]]
Output: 2
```

The room used for [9,10) is free for [10,11).

## Example 2

```text
Input: intervals = [[1,2],[2,3]]
Output: 1
```

The meetings do not overlap.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
