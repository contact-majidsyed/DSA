# Daily Temperatures

Difficulty: **MEDIUM**

## Question

For each day return how many days until a strictly warmer temperature, or zero if none.

## Input

An integer array temperatures in chronological order.

## Output

An array of days until a strictly warmer temperature; zero if none follows.

## Example 1

```text
Input: temperatures = [73,74,75,71,69,72,76]
Output: [1,1,4,2,1,1,0]
```

The temperature 75 at index 2 waits until index 6.

## Example 2

```text
Input: temperatures = [30,30]
Output: [0,0]
```

An equal temperature is not warmer.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
