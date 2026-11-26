# Minimum Window Substring

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **HIGH** | Pattern: **Sliding window + frequency map**

## Problem

Return the shortest substring of s containing all characters of t, including duplicates; return empty if impossible.

## ASCII walkthrough

```text
s = ADOBECODEBANC, t = ABC
    [ADOBEC]         first valid window
             [BANC] shortest valid window
expand right -> satisfy counts -> shrink left
```

## How the code works

The map stores remaining demand, which may become negative for surplus characters. Missing counts individual required occurrences. Once missing is zero, record the window and remove leftmost characters until one required occurrence is lost.

[Java solution](Solution.java)

## Complexity

Time O(|s| + |t|) expected; auxiliary space O(distinct characters in t), plus O(|t|) temporary char array in this implementation; output O(|s|) worst case.

## Edge cases and assumptions

Repeated required characters; empty t; no valid window; Java char semantics.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
