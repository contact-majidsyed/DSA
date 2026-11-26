# Implement Trie

Difficulty: **MEDIUM** | Pattern: **Prefix tree**

## Problem

Implement insert, exact search, and startsWith for lowercase English strings.

## ASCII walkthrough

```text
root
 |
 a
 |
 p
 +-- p* -- l -- e*
 |
 +-- e*
* marks complete words: app, apple, ape
```

## How the code works

Each edge represents a letter. Shared prefixes reuse nodes. Search requires reaching an end marker; startsWith only requires reaching a node. Instantiate as new Solution.Trie(). Inserting an empty word marks the root; the empty prefix always exists.

[Java solution](Solution.java)

## Complexity

Insert/search/startsWith time O(L); operation auxiliary space O(1) excluding new nodes. Total storage O(26 * P), P distinct prefix nodes, hence O(total inserted characters) for fixed alphabet.

## Edge cases and assumptions

Word versus prefix; duplicate insertion; empty word/prefix; lowercase a-z only.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
