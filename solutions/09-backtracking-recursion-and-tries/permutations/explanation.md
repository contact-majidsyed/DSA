# Permutations

Difficulty: **MEDIUM** | Pattern: **Backtracking with used flags**

## Problem

Return all orderings of distinct input integers.

## ASCII walkthrough

```text
        []
     /   |   \
   [1]  [2]  [3]
   / \
[1,2] [1,3]
  |      |
[1,2,3] [1,3,2]
repeat branches starting with 2 and 3 -> 6 results
```

## How the code works

Try every unused index at each position. Mark it, append its value, recurse, then restore both path and used flag. Save only full-length paths. Distinct input values prevent duplicate permutations.

[Java solution](Solution.java)

## Complexity

Time O(n * n!); auxiliary space O(n); output O(n * n!).

## Edge cases and assumptions

Empty input yields one empty permutation; one element; distinct values required.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
