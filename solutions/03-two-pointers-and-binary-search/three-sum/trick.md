# 3Sum: Quick Recall

**Trick:** Sort, fix one value, then move two pointers through the suffix. Skip duplicate fixed values and duplicate matches.

**Key code:** `if (i > 0 && nums[i] == nums[i - 1]) continue;`

**Looks like:** [-4,-1,-1,0,1,2]: fix -1 -> pairs (-1,2) and (0,1) complete zero sums.

**Remember:** Fix one; find the other two.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
