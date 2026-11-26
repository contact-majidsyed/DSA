# Kth Largest Element in an Array

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Bounded min-heap**

## Problem

Return the kth largest element, counting duplicates separately. Require 1 <= k <= length.

## ASCII walkthrough

```text
nums=[3,2,1,5,6,4], k=2
retained values (sorted here for display):
3 -> [3]
2 -> [2,3]
1 -> [2,3]
5 -> [3,5]
6 -> [5,6]
4 -> [5,6]
smallest retained value = 5
```

## How the code works

Keep only the k largest values seen so far. Whenever the heap grows beyond k, discard its smallest. At the end, the heap minimum is the kth largest. A PriorityQueue is not fully sorted when iterated.

[Java solution](Solution.java)

## Complexity

Time O(n log(k + 1)); auxiliary space O(k).

## Edge cases and assumptions

k = 1 or n; duplicates; negatives; invalid k rejected.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
