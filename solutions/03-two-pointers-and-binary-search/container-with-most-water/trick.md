# Container With Most Water: Quick Recall

**Trick:** Move the shorter endpoint: keeping it and reducing width cannot improve the area. If heights tie, either endpoint may move.

**Key code:** `if (height[left] <= height[right]) left++;`

**Looks like:** Heights 8 and 7 at indices 1 and 8 -> area 7*7=49; move the endpoint with height 7.

**Remember:** The shorter wall limits the water.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
