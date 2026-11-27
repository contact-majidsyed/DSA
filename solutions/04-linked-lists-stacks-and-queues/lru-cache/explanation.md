# LRU Cache

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **HIGH** | Pattern: **HashMap + doubly linked list**

## Problem

Implement integer-key/value get and put with least-recently-used eviction. Missing keys return -1. Capacity must be nonnegative.

## ASCII walkthrough

```text
most recent                    least recent
HEAD <-> A <-> B <-> C <-> TAIL
get(B):
HEAD <-> B <-> A <-> C <-> TAIL
put(D) at capacity 3: evict C
HEAD <-> D <-> B <-> A <-> TAIL
```

## How the code works

The map locates nodes directly. Sentinel head and tail make insertion/removal uniform. Both get and an update count as access and move the node to the front. Remove the tail's previous node if capacity is exceeded. Instantiate as new Solution.LRUCache(capacity). This educational cache is not thread-safe.

[Java solution](Solution.java)

## Complexity

Expected O(1) get/put; space O(capacity), with a temporary extra node during insertion.

## Edge cases and assumptions

Zero capacity; updating existing keys; repeated gets; eviction order.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
