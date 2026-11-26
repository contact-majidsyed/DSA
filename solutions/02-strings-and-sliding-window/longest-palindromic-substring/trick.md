# Longest Palindromic Substring: Quick Recall

**Trick:** Expand from both a single character and a gap between characters; otherwise even-length answers are missed.

**Key code:** `int even = expand(s, i, i + 1);`

**Looks like:** "cbbd": the gap between b and b expands to "bb"; a single-character center cannot find it.

**Remember:** Try a letter and a gap.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
