# Longest Repeating Character Replacement

Difficulty: **MEDIUM**

## Question

Find the longest substring that can be made uniform with at most k replacements. Input uses uppercase A-Z and k >= 0.

## Input

An uppercase English string s and nonnegative replacement budget k.

## Output

The maximum length of a substring that can become one repeated letter with at most k replacements.

## Example 1

```text
Input: s = "AABABBA", k = 1
Output: 4
```

Change B in the first four characters to A.

## Example 2

```text
Input: s = "ABAB", k = 2
Output: 4
```

Replace both B characters with A.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
