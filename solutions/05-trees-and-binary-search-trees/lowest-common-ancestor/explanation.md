# Lowest Common Ancestor of a Binary Tree

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Recursive DFS**

## Problem

Return the deepest node ancestral to both p and q. Both nodes are assumed present; a node can be its own ancestor.

## ASCII walkthrough

```text
    3
   / \
  5   1
 / \
6   2
p=6, q=2
at 5: left finds 6, right finds 2 -> return 5
at 3: only left returns a match -> propagate 5
```

## How the code works

Stop at a target node or null. If both subtrees report a target, the current node joins their paths and is the answer. If only one reports a match, pass that result upward. Compare node references, not values. If targets may be absent, add presence validation.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(h).

## Edge cases and assumptions

One target is an ancestor of the other; p equals q; repeated values; both targets must exist.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
