# 3Sum

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Sorting + two pointers**

## Problem

Return unique triplets summing to zero. This solution sorts the input in place.

## ASCII walkthrough

```text
sorted: [-4,-1,-1,0,1,2]
fix index 1 (-1)
L=index 2 (-1), R=index 5 (2) -> sum 0
L=index 3 (0),  R=index 4 (1) -> sum 0
result: [-1,-1,2], [-1,0,1]
```

## How the code works

After sorting, fix one value and search the suffix with two pointers. A negative sum needs a larger left value; a positive sum needs a smaller right value. Skip duplicate fixed values and matching pointer values to avoid duplicate triplets.

[Java solution](Solution.java)

## Complexity

Time O(n^2); pointer work uses O(1) auxiliary space, plus the JDK primitive sorting implementation's workspace; output O(n^2) worst case.

## Edge cases and assumptions

Duplicate zeros; no answer; fewer than three numbers; input is mutated; long sum avoids overflow.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
