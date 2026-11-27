# Accounts Merge

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Union Find**

## Problem

Each account is [name, email, ...] with at least one email. Merge accounts sharing emails, sorting emails within each result. Connected accounts have consistent names.

## ASCII walkthrough

```text
[Alex, x@example.com, y@example.com]
[Alex, y@example.com, z@example.com]
union x--y and y--z
component: x--y--z
merged: [Alex, x@example.com, y@example.com, z@example.com]
```

## How the code works

Create one node per distinct email. Union every email in an account with its first email. Path compression and union by size keep representative lookup efficient. Group by root, sort each group, and prepend its owner name. Same name alone never implies the same person.

[Java solution](Solution.java)

## Complexity

For M email occurrences and U unique emails: expected O(M * alpha(U) + U log U) treating string operations as unit cost; auxiliary/output space O(U). String hashing and sorting comparisons also depend on email length.

## Edge cases and assumptions

Transitive overlap; duplicate emails; same name without shared emails; result group order unspecified.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
