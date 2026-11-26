# Valid Anagram

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **Frequency counter**

## Problem

Determine whether two lowercase English strings have the same character frequencies.

## ASCII walkthrough

```text
listen -> add counts
silent -> subtract counts
all 26 slots = 0 -> true
```

## How the code works

Length must match. Add one for each letter in the first string and subtract one for each letter in the second. A zero balance in every slot proves equal frequencies.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1) for 26 letters.

## Edge cases and assumptions

Empty strings; repeated letters; unequal lengths; lowercase a-z only.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
