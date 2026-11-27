# Product of Array Except Self

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Prefix / suffix**

## Problem

Return each element's product excluding itself without division. Assume prefix, suffix, and result products fit int.

## ASCII walkthrough

```text
input:  [1, 2, 3, 4]
prefix: [1, 1, 2, 6]
suffix: [24,12,4, 1]
result: [24,12,8, 6]
```

## How the code works

Store the product strictly to the left at each index. Walk backward and multiply by the product strictly to the right. Update prefix or suffix only after using it, so the current element is excluded.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1), excluding O(n) output.

## Edge cases and assumptions

One zero; multiple zeros; negative values; empty input.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
