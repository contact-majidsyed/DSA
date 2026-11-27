# Valid Palindrome: Quick Recall

**Trick:** Skip non-alphanumeric characters at each end, then compare lowercase characters while moving inward.

**Key code:** `if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;`

**Looks like:** "A, a" -> compare A with a -> equal after lowercasing -> true.

**Remember:** Skip, compare, move inward.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
