# Maximum Depth of Binary Tree

Difficulty: **LOW** | Pattern: **Recursive DFS**

## Problem

Return the number of nodes on the longest root-to-leaf path.

## ASCII walkthrough

```text
    1
   / \
  2   3
 /
4
depth(4)=1, depth(2)=2, depth(3)=1
depth(1)=1+max(2,1)=3
```

## How the code works

An empty subtree contributes zero. Each real node contributes one plus the deeper child result. The recursive call stack follows the current root-to-leaf path.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(h), where h is tree height.

## Edge cases and assumptions

Null root; one node; skewed tree. Deep recursion may exhaust the Java stack; an iterative traversal is a follow-up.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
