# Lowest Common Ancestor of a Binary Tree: Quick Recall

**Trick:** Assuming both targets exist, return matches upward. If both child subtrees report a match, the current node is their common ancestor.

**Key code:** `if (left != null && right != null) return root;`

**Looks like:** Node 5 has children 6 and 2; for targets 6 and 2, both sides return a match -> answer node 5.

**Remember:** Two sides meet here.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
