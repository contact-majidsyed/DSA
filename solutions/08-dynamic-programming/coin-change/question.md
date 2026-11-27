# Coin Change

Difficulty: **MEDIUM**

## Question

Find the minimum coins making amount using unlimited copies of positive denominations. Return -1 if impossible. amount >= 0 and must fit an allocated DP array.

## Input

Positive coin denominations and a nonnegative amount; coins may be reused without limit.

## Output

The fewest coins summing to amount, or -1 if impossible.

## Example 1

```text
Input: coins = [1,2,5], amount = 11
Output: 3
```

Use 5 + 5 + 1.

## Example 2

```text
Input: coins = [2], amount = 3
Output: -1
```

No number of 2-value coins makes 3.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
