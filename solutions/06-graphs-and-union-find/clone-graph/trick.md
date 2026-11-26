# Clone Graph: Quick Recall

**Trick:** Store each original-to-copy mapping before exploring neighbors. Cycles then reuse existing copies instead of recursing or queuing forever.

**Key code:** `copies.put(neighbor, new Node(neighbor.val));`

**Looks like:** Original A<->B -> map {A:A', B:B'} -> copies A'<->B'; no copied edge points to an original.

**Remember:** Copy once, connect through the map.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
