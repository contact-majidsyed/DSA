# Subsets

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Backtracking**

## Problem

Return every subset of distinct integers, including the empty subset.

## ASCII walkthrough

```text
        []
       /  \
     [1]  [2]
      |
    [1,2]
result: [], [1], [1,2], [2]
```

## How the code works

Record a copy of the current subset at each call. Choose each remaining index, recurse starting after it, then undo the choice. Increasing indices prevent permutations of the same subset. Copying path is essential because the working list changes.

[Java solution](Solution.java)

## Complexity

Time O(n * 2^n); auxiliary space O(n); output O(n * 2^n).

## Edge cases and assumptions

Empty input yields one empty subset; input values must be distinct.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
