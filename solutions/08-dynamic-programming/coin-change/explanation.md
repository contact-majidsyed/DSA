# Coin Change

Difficulty: **MEDIUM** | Pattern: **Unbounded amount DP**

## Problem

Find the minimum coins making amount using unlimited copies of positive denominations. Return -1 if impossible. amount >= 0 and must fit an allocated DP array.

## ASCII walkthrough

```text
coins=[1,2,5], amount=11
dp[0]=0
dp[5]=1   (5)
dp[10]=2  (5+5)
dp[11]=3  (5+5+1)
```

## How the code works

For every amount, try each denomination as the final coin. Positive denominations ensure the previous amount is smaller and already solved. amount+1 is a safe unreachable sentinel because any reachable amount needs at most amount positive-value coins.

[Java solution](Solution.java)

## Complexity

Time O(amount * number of coins); auxiliary space O(amount).

## Edge cases and assumptions

Amount zero; empty coin list; unreachable amount; denomination greater than target; only positive coins.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
