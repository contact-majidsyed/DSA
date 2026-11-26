# Climbing Stairs

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **Rolling Fibonacci DP**

## Problem

Count ways to reach step n using steps of size 1 or 2. Define n=0 as one empty sequence. Require 0 <= n <= 91 for a long result.

## ASCII walkthrough

```text
step: 0 1 2 3 4
ways: 1 1 2 3 5
ways(4) = ways(3) + ways(2)
        = 3 + 2 = 5
```

## How the code works

The final move comes from either one step below or two steps below. Those two disjoint sets of paths sum to the total. Keep just the two previous counts. Larger n requires BigInteger.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Zero steps; one step; overflow bound explicitly enforced.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
