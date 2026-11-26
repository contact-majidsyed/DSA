# Maximum Subarray: Quick Recall

**Trick:** Choose between starting here and extending the old sum; update best separately so an earlier winner survives.

**Key code:** `current = Math.max(nums[i], current + nums[i]);`

**Looks like:** [4,-1,2,1,-5]: current=1 at the end, but best=6 from [4,-1,2,1].

**Remember:** Start or extend; save the best.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

// As we dont have to return the subarray and just that sum, this makes the implementation bit easier
