# Longest Increasing Subsequence: Quick Recall

**Trick:** Replace the first tail >= the new value; append only if no such tail exists. tails stores minimum endings, not necessarily an actual subsequence.

**Key code:** `if (tails[mid] < num) left = mid + 1;`

**Looks like:** [10,9,2,5,3,7] -> tails [10] -> [9] -> [2] -> [2,5] -> [2,3] -> [2,3,7].

**Remember:** Smaller endings leave more room.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
