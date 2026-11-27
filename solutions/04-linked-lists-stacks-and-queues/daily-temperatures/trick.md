# Daily Temperatures: Quick Recall

**Trick:** Store unresolved indices, not temperatures alone. A warmer day resolves colder indices on top; the answer is their index distance.

**Key code:** `answer[previous] = i - previous;`

**Looks like:** [73,74,75]: at i=1, pop index 0 -> answer[0]=1; at i=2, pop index 1 -> answer[1]=1.

**Remember:** A warmer day settles waiting days.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
