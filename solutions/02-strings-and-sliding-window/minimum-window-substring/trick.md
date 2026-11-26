# Minimum Window Substring: Quick Recall

**Trick:** Expand until every required occurrence is covered, then shrink until removing a required character breaks coverage.

**Key code:** `if (need.get(removed) > 0) missing++;`

**Looks like:** s="ADOBECODEBANC", t="ABC": first valid "ADOBEC", final shortest "BANC".

**Remember:** Cover everything, then trim.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
