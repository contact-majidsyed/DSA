# Word Break

Difficulty: **MEDIUM** | Pattern: **Prefix DP**

## Problem

Determine whether s can be split into dictionary words; words can be reused. Dictionary words are nonempty.

## ASCII walkthrough

```text
s = leetcode
    |leet|code|
dp[0]=true
dp[4]=true because dp[0] and "leet" matches
dp[8]=true because dp[4] and "code" matches
```

## How the code works

dp[end] means the prefix ending just before end can be segmented. Try dictionary words as the last segment and require the preceding prefix to be reachable. startsWith checks the word without allocating substrings. This implementation has different bounds from a substring-based double loop.

[Java solution](Solution.java)

## Complexity

Let n be string length, D unique dictionary size, L maximum word length, and S total dictionary characters. Time O(S + n * D * L) worst case; auxiliary space O(n + D) references. Dictionary strings are not copied.

## Edge cases and assumptions

Empty s returns true; impossible suffix; overlapping word choices; words reusable.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
