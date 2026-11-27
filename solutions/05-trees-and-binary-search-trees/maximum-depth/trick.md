# Maximum Depth of Binary Tree: Quick Recall

**Trick:** An empty subtree has depth zero; a real node adds one to the deeper child's depth.

**Key code:** `return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));`

**Looks like:** Root 1 with left path 2->4 and right child 3 -> left depth 2, right depth 1 -> answer 3.

**Remember:** One plus the deeper side.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
