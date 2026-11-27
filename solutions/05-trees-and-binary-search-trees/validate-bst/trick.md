# Validate Binary Search Tree: Quick Recall

**Trick:** Carry ancestor bounds down the tree; comparing a node only with its parent misses violations.

**Key code:** `if (node.val <= low || node.val >= high) return false;`

**Looks like:** 5 -> right child 8 -> left child 4: allowed range is (5,8), so 4 is invalid.

**Remember:** Every ancestor sets a boundary.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
