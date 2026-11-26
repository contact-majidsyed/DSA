# Validate Binary Search Tree

Difficulty: **MEDIUM** | Pattern: **DFS with bounds**

## Problem

Determine whether every node respects strict BST ordering; duplicate values are invalid.

## ASCII walkthrough

```text
    5
   / \
  3   8
     /
    4  <- invalid: inside right subtree of 5
allowed bounds here: (5,8)
4 violates inherited lower bound
```

## How the code works

Checking only immediate children is insufficient. Carry the complete allowed range down the recursion. The left child tightens the upper bound, and the right child tightens the lower bound. Long bounds allow every int value.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(h).

## Edge cases and assumptions

Null root is valid; duplicates invalid; Integer.MIN_VALUE and MAX_VALUE; ancestor violations.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
