# Task Scheduler: Quick Recall

**Trick:** The most frequent tasks set a spacing bound: (max-1)*(n+1)+tied. Take the larger of that and the task count; empty input returns zero.

**Key code:** `return Math.max(tasks.length, frame);`

**Looks like:** AAABBB, cooldown=2 -> A B idle / A B idle / A B -> 8 slots.

**Remember:** Space the busiest tasks; fill the gaps.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
