# Word Search: Quick Recall

**Trick:** Mark cells only for the current path, and unmark on return so other paths may use them. This solution keeps a separate used grid.

**Key code:** `used[r][c] = false;`

**Looks like:** ABCCED path: (0,0)->(0,1)->(0,2)->(1,2)->(2,2)->(2,1); no cell repeats.

**Remember:** Used on this path, not forever.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
