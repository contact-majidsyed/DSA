# LRU Cache: Quick Recall

**Trick:** Use a map to locate nodes and a doubly linked list to reorder them. Both get and updating put move a node to the front; evict from the back.

**Key code:** `Node victim = tail.prev;`

**Looks like:** HEAD <-> A <-> B <-> C <-> TAIL; get(B) -> HEAD <-> B <-> A <-> C <-> TAIL.

**Remember:** Front is recent; back gets evicted.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
