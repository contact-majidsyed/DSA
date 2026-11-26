# Design a Distributed Cache

Difficulty: **HIGH**

## Reference approach

Provide low-latency get, set, and delete operations with TTLs. Clarify whether lost cache entries are acceptable, consistency needs, value sizes, and expected working-set size.

API: `get(key)`, `set(key,value,ttl)`, and `delete(key)`. Store value, expiry, and optional version metadata. Use consistent hashing with virtual nodes or a managed partition map to assign keys across nodes. Clients or routers need versioned topology information and retry rules during movement.

Each node enforces memory limits with an eviction policy such as approximate LRU. Expiry and eviction are separate: an expired item must not be served even if background cleanup has not removed it. Replicas improve availability; asynchronous replication can lose recent updates and serve stale data after failover.

For cache-aside use, applications query the durable source on a miss and populate the cache. Coordinate concurrent fills with request coalescing, use TTL jitter to avoid synchronized expiry, and allow stale-while-revalidate only when the product tolerates it. Versioned writes or coordinated invalidation may be needed to avoid an old cache fill overwriting a newer value.

Rebalance gradually with bounded migration load. Hot keys need replication or local caching; adding ordinary partitions alone does not spread one key. Protect the source store with rate limits and circuit breakers during cache failure. Measure hit rate, tail latency, eviction rate, memory, and source load. State whether the cache is disposable; durability requires a separate persistence and recovery contract.

[ASCII explanation](explanation.md)
