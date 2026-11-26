# Implement Trie

Difficulty: **MEDIUM**

## Question

Implement insert, exact search, and startsWith for lowercase English strings.

## Input

A sequence of insert(word), search(word), and startsWith(prefix) operations on lowercase strings.

## Output

search and startsWith return booleans; insert has no return value.

## Example 1

```text
Input: insert("apple"); search("apple"); search("app"); startsWith("app")
Output: query results: [true,false,true]
```

"app" is a prefix but has not been inserted as a complete word.

## Example 2

```text
Input: insert("app"); search("app"); startsWith("bat")
Output: query results: [true,false]
```

The inserted word exists; no word begins with "bat". Each example starts with an empty trie.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
