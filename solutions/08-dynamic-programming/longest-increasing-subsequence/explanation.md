# Longest Increasing Subsequence

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Binary search over tails**

## Problem

Return the length of a strictly increasing subsequence; elements need not be adjacent.

## ASCII walkthrough

```text
input: 10,9,2,5,3,7,101,18
tails: [10] -> [9] -> [2] -> [2,5]
       -> [2,3] -> [2,3,7] -> [2,3,7,101]
       -> [2,3,7,18]
length = 4
```

## How the code works

tails[i] is the smallest known last value of an increasing subsequence of length i+1. Binary-search the first value greater than or equal to num and replace it. Smaller tails leave more room for future extension. The tails array is not guaranteed to be an actual subsequence; this method returns only length.

[Java solution](Solution.java)

## Complexity

Time O(n log(n + 1)); auxiliary space O(n).

## Edge cases and assumptions

Empty input; duplicates do not increase length; descending sequence; negatives.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
