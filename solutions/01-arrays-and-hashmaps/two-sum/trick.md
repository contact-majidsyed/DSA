# Two Sum: Quick Recall

**Trick:** Check for the missing partner before saving the current number, so you cannot use one index twice.

**Key code:** `long need = (long) target - nums[i];`

**Looks like:** [2,7], target=9: after 2, seen={2:0}; at 7, need=2 -> indices [0,1].

**Remember:** Look up first, store second.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
