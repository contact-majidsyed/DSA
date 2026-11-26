# Linked List Cycle: Quick Recall

**Trick:** Move slow one step and fast two; compare node identity after moving. Repeated values alone do not mean a cycle.

**Key code:** `if (slow == fast) return true;`

**Looks like:** 1->2->3->2...: fast eventually meets slow inside the cycle.

**Remember:** Different speeds, same node.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
