# Merge Intervals: Quick Recall

**Trick:** Sort by start; compare each interval only with the last merged result. Closed intervals sharing an endpoint overlap.

**Key code:** `last[1] = Math.max(last[1], interval[1]);`

**Looks like:** [1,3] + [2,6] -> [1,6]; then [8,10] starts a separate result.

**Remember:** Sort starts; extend the last end.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
