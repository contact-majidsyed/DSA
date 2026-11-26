# Accounts Merge

Difficulty: **MEDIUM**

## Question

Each account is [name, email, ...] with at least one email. Merge accounts sharing emails, sorting emails within each result. Connected accounts have consistent names.

## Input

Accounts [name,email,...], each with at least one email; connected accounts have consistent names.

## Output

Merged accounts with unique sorted emails; group order does not matter.

## Example 1

```text
Input: accounts = [["Alex","x@example.com","y@example.com"],["Alex","y@example.com","z@example.com"]]
Output: [["Alex","x@example.com","y@example.com","z@example.com"]]
```

The shared email connects the accounts.

## Example 2

```text
Input: accounts = [["Alex","a@example.com"],["Alex","b@example.com"]]
Output: [["Alex","a@example.com"],["Alex","b@example.com"]]
```

Matching names alone do not justify merging.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
