# Serialize and Deserialize Binary Tree: Quick Recall

**Trick:** Use the same traversal for writing and reading, and include null markers so tree shape is not lost.

**Key code:** `if (node == null) { out.append("#,"); return; }`

**Looks like:** Root 1 with children 2 and 3 -> "1,2,#,#,3,#,#," -> the same tree on read.

**Remember:** Save the missing children too.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
