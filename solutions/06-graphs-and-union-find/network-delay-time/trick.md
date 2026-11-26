# Network Delay Time: Quick Recall

**Trick:** For nonnegative weights, expand the smallest tentative distance and skip stale heap entries; the answer is the largest final distance, or -1 if unreachable.

**Key code:** `if (d != distance[node]) continue;`

**Looks like:** A->B=2, A->C=5, B->C=1: visiting B improves C from 5 to 3; old entry 5 is stale.

**Remember:** Closest first; ignore old distances.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
