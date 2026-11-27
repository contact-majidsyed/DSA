# Group Anagrams

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Frequency signature + HashMap**

## Problem

Group words with identical character counts. Input words contain only lowercase English letters.

## ASCII walkthrough

```text
letter: a b c d e ... n ... t ... z
eat:    1 0 0 0 1 ... 0 ... 1 ... 0
tea:    1 0 0 0 1 ... 0 ... 1 ... 0
tan:    1 0 0 0 0 ... 1 ... 1 ... 0

frequency key -> list
a1,e1,t1      -> [eat, tea, ate]
a1,n1,t1      -> [tan, nat]
a1,b1,t1      -> [bat]
```

## How the code works

Create a fresh 26-slot array for each word. In `count[c - 'a']++`, subtracting 'a' maps a to index 0, e to index 4, and z to index 25. Increment that slot for every occurrence. `Arrays.toString(count)` includes all 26 counts and separators, making equal frequencies equal String keys; the diagram abbreviates them. `computeIfAbsent(key, k -> new ArrayList<>())` creates and stores a list only when the key is missing, then returns that list. `.add(s)` appends the original word. `map.values()` returns the groups, and the outer ArrayList is the result. Group order is unspecified. This is the frequency solution from the conversation, not the sorting alternative.

[Java solution](Solution.java)

## Complexity

Time O(N * (K + 26)) for N words of maximum length K under ordinary bounded integer/string operations. Auxiliary storage holds group references and up to N signatures; a conservative bound including signature text is O(N * (26 * log(K + 2) + 1) + K). Input strings are referenced, not copied.

## Edge cases and assumptions

Empty input; empty words; repeated words; lowercase a-z only. Use Arrays.toString for printing a 1D array, Arrays.deepToString for nested arrays.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
