# Number of Islands: Quick Recall

**Trick:** Each unseen land cell starts one island. Mark land when pushing it, so another neighbor cannot push it again; this solution changes the grid.

**Key code:** `grid[nr][nc] = '0';`

**Looks like:** ["1100","1001","0011"] -> one upper-left component and one right component -> 2 islands.

**Remember:** Find land, flood it, count once.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
