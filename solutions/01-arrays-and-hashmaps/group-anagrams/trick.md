# Group Anagrams: Quick Recall

**Trick:** For lowercase a-z, count letters in 26 slots and use Arrays.toString(count) as the map key.

**Key code:** `count[c - 'a']++;`

**Looks like:** "eat" -> count=[1,0,0,0,1,...,1,...]; slots 0(a), 4(e), 19(t) are 1, all others 0. The ellipses abbreviate 26 entries.

**Remember:** Letter -> slot -> count -> group.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
