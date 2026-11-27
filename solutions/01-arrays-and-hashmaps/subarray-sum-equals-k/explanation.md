# Subarray Sum Equals K

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Prefix sum + frequency map**

## Problem

Count contiguous subarrays whose sum equals k.

## ASCII walkthrough

```text
nums = [1,2,3], k = 3
prefix: 0 -> 1 -> 3 -> 6
                 |    |
need prefix:     0    3
subarray:      [1,2] [3]
answer = 2
```

## How the code works

A subarray sum is current prefix minus an earlier prefix. Store how many times each earlier prefix appeared. Seed zero once to count subarrays beginning at index zero. Query before recording the current prefix. Long sums and a long return value avoid ordinary int overflow.

[Java solution](Solution.java)

## Complexity

Time O(n) expected; auxiliary space O(n).

## Edge cases and assumptions

Negative numbers; k = 0; repeated zero prefixes; empty input.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
