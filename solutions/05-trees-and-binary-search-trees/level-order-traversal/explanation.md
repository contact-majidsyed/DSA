# Binary Tree Level Order Traversal

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **BFS queue**

## Problem

Return tree node values grouped by level from left to right.

## ASCII walkthrough

```text
    1
   / \
  2   3
 / \
4   5
queue batch [1]   -> level [1]
queue batch [2,3] -> level [2,3]
queue batch [4,5] -> level [4,5]
```

## How the code works

Capture queue size before processing a level. Children added during that batch belong to the next level, so the fixed size prevents mixing levels.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(w) for maximum width w; output O(n).

## Edge cases and assumptions

Null root returns empty list; one node; very wide or skewed tree.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
