# Course Schedule

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Topological sort**

## Problem

Given pairs [course, prerequisite] and courses 0 through n-1, determine if all courses can be completed.

## ASCII walkthrough

```text
0 -> 1 -> 2
indegree: [0,1,1]
remove 0 -> [0,0,1], enqueue 1
remove 1 -> [0,0,0], enqueue 2
processed 3 of 3 -> true
```

## How the code works

Edges run from prerequisite to dependent course. Begin with courses requiring nothing. Completing a course removes its outgoing dependencies. If a cycle remains, its courses never reach indegree zero, so fewer than n courses are processed.

[Java solution](Solution.java)

## Complexity

Time O(V + E); auxiliary space O(V + E).

## Edge cases and assumptions

Disconnected courses; no edges; self-dependency; directed cycle; valid course indices assumed.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
