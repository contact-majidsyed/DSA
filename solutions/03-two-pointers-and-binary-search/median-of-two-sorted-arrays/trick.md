# Median of Two Sorted Arrays: Quick Recall

**Trick:** Binary-search a cut in the smaller array; the other cut fixes the left-side size. Both left boundaries must be <= the opposite right boundaries.

**Key code:** `if (al <= br && bl <= ar) {`

**Looks like:** a=[2], b=[1,3]: cuts [2 / ] and [1 / 3] -> left max=2 -> median 2.

**Remember:** Correct size, then correct boundaries.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
