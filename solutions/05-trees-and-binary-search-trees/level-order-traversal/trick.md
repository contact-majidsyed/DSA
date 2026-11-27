# Binary Tree Level Order Traversal: Quick Recall

**Trick:** Freeze the queue size before processing a level; children you enqueue belong to the next level.

**Key code:** `int size = queue.size();`

**Looks like:** queue=[2,3], size=2: process only those two nodes, even as children [4,5] enter the queue.

**Remember:** One saved queue size per level.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
