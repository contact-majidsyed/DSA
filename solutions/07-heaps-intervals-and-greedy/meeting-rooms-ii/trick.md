# Meeting Rooms II: Quick Recall

**Trick:** Sort by start; remove all end times <= the next start, then add that meeting. The largest active heap size is the room count.

**Key code:** `while (!ends.isEmpty() && ends.peek() <= interval[0]) ends.remove();`

**Looks like:** [9,10), [9,12), [10,11): at 10 remove end 10, keep end 12, add end 11 -> 2 active.

**Remember:** Free finished rooms before counting.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
