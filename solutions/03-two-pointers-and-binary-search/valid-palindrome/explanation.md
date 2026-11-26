# Valid Palindrome

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **Two pointers**

## Problem

Ignore non-alphanumeric characters and compare case-insensitively. Assume ASCII input.

## ASCII walkthrough

```text
A man, a plan, a canal: Panama
L -------------------------- R
skip punctuation, compare a == a
move inward until pointers meet
```

## How the code works

Skip punctuation on both sides, compare normalized characters, and move inward. Every character is visited at most once. Empty or punctuation-only strings are palindromes.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Empty input; punctuation only; mixed case; digits.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
