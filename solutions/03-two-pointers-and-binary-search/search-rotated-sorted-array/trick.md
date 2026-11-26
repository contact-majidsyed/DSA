# Search in Rotated Sorted Array: Quick Recall

**Trick:** With distinct values, one half is sorted. Check whether target lies in that half's range before discarding a half.

**Key code:** `if (nums[left] <= nums[mid]) {`

**Looks like:** [4,5,6,7,0,1,2], target=0: [4,5,6,7] is sorted but excludes 0 -> search right.

**Remember:** Find the sorted half first.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
