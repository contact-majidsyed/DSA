# Combination Sum

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Backtracking with reuse**

## Problem

Return unique combinations of distinct positive candidates summing to a nonnegative target. Values may be reused. Input is sorted in place.

## ASCII walkthrough

```text
candidates=[2,3,6,7], target=7
[]
+-- [2] -> [2,2] -> [2,2,3] (success)
+-- [3] -> [3,3] (no match for remainder 1)
+-- [6] (no match for remainder 1)
+-- [7] (success)
[3,2,2] is never generated: indices cannot move backward
```

## How the code works

Sort candidates for early stopping. Pass i, rather than i+1, to allow reuse. Keep the index nondecreasing to avoid duplicate orderings. Undo each choice after recursion. Strictly positive values guarantee remaining decreases.

[Java solution](Solution.java)

## Complexity

With C candidates, depth D=floor(target/minCandidate), and R answers: a conservative bound is O(C log C + (C+1)^(D+1) + R*D) time; auxiliary recursion/path O(D), plus sorting workspace; output O(R*D).

## Edge cases and assumptions

Target zero returns one empty combination; no solution; empty candidates; only distinct positive candidates; input order changes.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
