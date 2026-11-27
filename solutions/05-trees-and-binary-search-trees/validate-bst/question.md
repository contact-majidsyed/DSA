# Validate Binary Search Tree

Difficulty: **MEDIUM**

## Question

Determine whether every node respects strict BST ordering; duplicate values are invalid.

## Input

A binary-tree root, shown as a level-order array with null for missing children.

## Output

true if every left descendant is smaller and every right descendant larger than its ancestor.

## Example 1

```text
Input: root = [2,1,3]
Output: true
```

Both subtrees satisfy strict ordering.

## Example 2

```text
Input: root = [5,3,8,null,null,4]
Output: false
```

The value 4 lies in the right subtree of 5 but is smaller than 5.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
