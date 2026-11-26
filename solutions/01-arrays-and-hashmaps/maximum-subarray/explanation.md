# Maximum Subarray

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Kadane dynamic programming**

## Problem

Find the maximum sum of a nonempty contiguous subarray. Input must be nonempty.

## ASCII walkthrough

```text
nums:    -2  1 -3  4 -1  2  1 -5  4
current: -2  1 -2  4  3  5  6  1  5
best:    -2  1  1  4  4  5  6  6  6
winning subarray: [4,-1,2,1]
```

## How the code works

At each index, either extend the best subarray ending just before it or start again at this number. Track the best result seen anywhere. Initialize from the first element so all-negative input works.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

All negatives; one element; zeros; long return handles larger sums.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
