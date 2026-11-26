# Course Schedule

Difficulty: **MEDIUM**

## Question

Given pairs [course, prerequisite] and courses 0 through n-1, determine if all courses can be completed.

## Input

A course count n and pairs [course, prerequisite], using indices 0 through n-1.

## Output

true if every course can be completed; otherwise false.

## Example 1

```text
Input: n = 3, prerequisites = [[1,0],[2,1]]
Output: true
```

One valid order is 0, then 1, then 2.

## Example 2

```text
Input: n = 2, prerequisites = [[1,0],[0,1]]
Output: false
```

Each course depends on the other, forming a cycle.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
