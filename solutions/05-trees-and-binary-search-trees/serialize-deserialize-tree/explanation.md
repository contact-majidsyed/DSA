# Serialize and Deserialize Binary Tree

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **HIGH** | Pattern: **Preorder encoding**

## Problem

Encode a binary tree as comma-separated preorder values with # for null, then reconstruct it. Deserialize expects valid output of serialize.

## ASCII walkthrough

```text
    1
   / \
  2   3
preorder: 1,2,#,#,3,#,#,
read 1 -> read left subtree 2,#,#
       -> read right subtree 3,#,#
```

## How the code works

Write a node before its children and record every missing child. Without null markers, different shapes can share the same value traversal. The reader consumes tokens in exactly the same order. Java split drops the trailing empty token.

[Java solution](Solution.java)

## Complexity

Time O(n) for fixed-width int values; auxiliary/output space O(n), with O(h) recursion.

## Edge cases and assumptions

Null tree serializes to #,; negative values; skewed trees; malformed input is outside the contract.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
