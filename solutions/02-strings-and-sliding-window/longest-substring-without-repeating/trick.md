# Longest Substring Without Repeating Characters: Quick Recall

**Trick:** Jump left past a repeated character's old position, but never move left backward.

**Key code:** `left = Math.max(left, last.get(c) + 1);`

**Looks like:** "abba": at the second b, left=2; at the last a, left stays 2 -> window "ba".

**Remember:** Move left forward only.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
