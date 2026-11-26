# Valid Anagram: Quick Recall

**Trick:** For equal-length lowercase strings, add counts for one string and subtract for the other; every slot must finish at zero.

**Key code:** `count[t.charAt(i) - 'a']--;`

**Looks like:** "aab" versus "aba" -> final count=[0,0,...,0] across all 26 slots.

**Remember:** Equal letters cancel.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
