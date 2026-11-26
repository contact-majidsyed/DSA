# House Robber

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Take / skip DP**

## Problem

Return the greatest sum from nonadjacent houses. Values are nonnegative.

## ASCII walkthrough

```text
houses: [2,7,9,3,1]
best:    2 7 11 11 12
take current -> best two positions back + value
skip current -> previous best
chosen: 2 + 9 + 1 = 12
```

## How the code works

Taking the current house forbids the previous house, so combine it with twoBack. Skipping preserves oneBack. Calculate the new answer before shifting the rolling states.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Empty input; one house; all zero; long totals.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
