# Word Break: Quick Recall

**Trick:** A prefix is reachable if it ends with a dictionary word and the prefix before that word was reachable; empty prefix is the starting point.

**Key code:** `if (start >= 0 && dp[start] && s.startsWith(word, start)) {`

**Looks like:** "leetcode", words=[leet,code]: dp[0]=true -> dp[4]=true -> dp[8]=true.

**Remember:** A solved prefix plus one word.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
