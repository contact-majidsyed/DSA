# Course Schedule: Quick Recall

**Trick:** Draw prerequisite -> course edges. Repeatedly remove indegree-zero courses; if fewer than n are processed, a cycle remains.

**Key code:** `if (--indegree[next] == 0) queue.add(next);`

**Looks like:** 0->1->2: indegrees [0,1,1] -> process 0, then 1, then 2 -> all finish.

**Remember:** No prerequisites left? Take the course.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
