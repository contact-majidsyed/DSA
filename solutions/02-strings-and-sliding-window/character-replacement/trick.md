# Longest Repeating Character Replacement: Quick Recall

**Trick:** Window length minus the most frequent count is the replacement cost. This length-only solution keeps a historical maxFrequency; the current window need not stay valid after shrinking.

**Key code:** `while (right - left + 1 - maxFrequency > k) {`

**Looks like:** "AABA", k=1: counts A=3, B=1 -> cost 4-3=1 -> length 4.

**Remember:** Keep the majority; replace the rest.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
