# Longest Substring Without Repeating Characters

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Sliding window**

## Problem

Return the maximum length of a substring with no repeated Java char values.

## ASCII walkthrough

```text
a b c a b c b b
[ a b c ]         length 3
  [ b c a ]       move left past first a
maximum = 3
```

## How the code works

Store the last index of each character. On a repeat, move left past the old occurrence only if that moves left forward. Math.max is essential for inputs like abba. Measure the valid window after updating left.

[Java solution](Solution.java)

## Complexity

Time O(n) expected; auxiliary space O(min(n, character alphabet)).

## Edge cases and assumptions

Empty input; abba; all identical. Java char uses UTF-16 code units, not full Unicode code points.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
