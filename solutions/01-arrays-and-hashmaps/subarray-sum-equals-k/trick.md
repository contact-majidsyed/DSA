# Subarray Sum Equals K: Quick Recall

**Trick:** Count earlier prefixes equal to sum-k. Seed prefix 0 once, and look up before recording the new prefix.

**Key code:** `answer += counts.getOrDefault(sum - k, 0L);`

**Looks like:** [1,2,3], k=3: prefixes 0,1,3,6; at 6, earlier prefix 3 identifies subarray [3].

**Remember:** Current prefix minus earlier prefix equals k.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
