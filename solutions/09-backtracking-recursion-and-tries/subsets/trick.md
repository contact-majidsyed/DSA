# Subsets: Quick Recall

**Trick:** Record a copy of the current path, then try remaining indices. Recurse with i+1 so each element is chosen at most once.

**Key code:** `collect(nums, i + 1, path, result);`

**Looks like:** [1,2]: paths [] -> [1] -> [1,2], backtrack, then [2].

**Remember:** Save the path; choose only forward.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
