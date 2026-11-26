# Lowest Common Ancestor of a Binary Tree

Difficulty: **MEDIUM**

## Question

Return the deepest node ancestral to both p and q. Both nodes are assumed present; a node can be its own ancestor.

## Input

A binary-tree root and references to two nodes p and q that are present in the tree.

## Output

The deepest node that is an ancestor of both; a node may be its own ancestor.

## Example 1

```text
Input: root = [3,5,1,6,2], p = node 6, q = node 2
Output: node 5
```

Both target nodes descend from node 5.

## Example 2

```text
Input: root = [3,5,1,6,2], p = node 5, q = node 6
Output: node 5
```

A target can itself be the common ancestor. Values identify nodes only for these examples.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
