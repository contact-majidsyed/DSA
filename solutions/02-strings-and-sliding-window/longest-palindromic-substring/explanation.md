# Longest Palindromic Substring

Difficulty: **MEDIUM** | Pattern: **Expand around center**

## Problem

Return a longest palindromic substring; any answer is accepted on ties.

## ASCII walkthrough

```text
odd center:    b a b
               < ^ >
even center:   c b b d
                 ^^
compare outward until mismatch or boundary
```

## How the code works

Try each position as an odd center and each adjacent pair as an even center. The helper stops one step beyond the palindrome, so its length is right - left - 1. Remember indices and copy only the final substring.

[Java solution](Solution.java)

## Complexity

Time O(n^2); auxiliary space O(1), excluding returned substring.

## Edge cases and assumptions

Empty input; one character; even palindrome; all identical; comparisons use Java char.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
