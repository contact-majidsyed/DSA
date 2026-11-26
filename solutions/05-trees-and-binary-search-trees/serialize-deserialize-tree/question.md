# Serialize and Deserialize Binary Tree

Difficulty: **HIGH**

## Question

Encode a binary tree as comma-separated preorder values with # for null, then reconstruct it. Deserialize expects valid output of serialize.

## Input

serialize takes a tree root; deserialize takes a string produced by serialize.

## Output

A serialized string, or a reconstructed tree of the same shape and values.

## Example 1

```text
Input: serialize(root = [1,2,3])
Output: "1,2,#,#,3,#,#,"
```

This repository uses preorder values and # for every missing child.

## Example 2

```text
Input: deserialize(data = "1,2,#,#,3,#,#,")
Output: root = [1,2,3]
```

Reconstruction restores the original tree. Tree arrays here are level-order notation.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
