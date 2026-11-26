# Longest Repeating Character Replacement

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Sliding window**

## Problem

Find the longest substring that can be made uniform with at most k replacements. Input uses uppercase A-Z and k >= 0.

## ASCII walkthrough

```text
A A B A B, k = 1
[A A B A] -> length 4, max count 3
4 - 3 = 1 replacement -> answer 4
```

## How the code works

Window length minus its largest frequency is the number of replacements needed. maxFrequency is a historical maximum and is not reduced when left moves. This may keep an invalid current window, but cannot produce a larger answer without a newly sufficient maximum count; it is safe for the maximum length, not for returning the current substring.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1) for 26 letters.

## Edge cases and assumptions

Empty input; k = 0; k exceeds length; uppercase A-Z only.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
