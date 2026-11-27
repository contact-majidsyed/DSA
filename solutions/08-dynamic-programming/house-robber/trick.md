# House Robber: Quick Recall

**Trick:** Taking this house uses the best total two positions back; skipping it keeps the previous best. Compute before shifting the states.

**Key code:** `long current = Math.max(oneBack, twoBack + value);`

**Looks like:** [2,7,9,3,1] -> best totals [2,7,11,11,12] -> select 2+9+1.

**Remember:** Take plus two-back, or skip.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
