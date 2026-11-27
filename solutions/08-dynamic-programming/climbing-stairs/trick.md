# Climbing Stairs: Quick Recall

**Trick:** The final move came from one step below or two below. Add their counts and keep only the last two.

**Key code:** `long next = previous + current;`

**Looks like:** Steps 0,1,2,3,4 -> ways [1,1,2,3,5]; n=0 includes the empty path.

**Remember:** Last step was one or two.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
