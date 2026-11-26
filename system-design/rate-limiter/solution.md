# Design a Rate Limiter

Difficulty: **MEDIUM**

## Reference approach

Limit requests per identity, route, or tenant. Clarify burst allowance, sustained rate, geographic scope, and whether limits must be exact.

API: an internal `allow(key, cost)` returns allowed status, remaining quota, and retry delay. A token bucket stores token balance and last refill time per key. Refill by `elapsed * rate`, cap at capacity, then subtract request cost only if enough tokens remain.

Perform refill/check/decrement atomically in a shared store, for example with a server-side script. Use a consistent clock source for shared state. Expire idle buckets only after enough time that a missing bucket can correctly restart full. Return HTTP 429 and a retry hint for rejected client traffic.

Partition by identity key. Local prefilters reduce shared-store load, but independently allocating full quotas to every node multiplies the actual limit. Global exact quotas require coordination; regional budgets trade exactness for availability and lower latency.

Choose fail-open or fail-closed per endpoint when the store fails. Fail-open preserves availability but risks abuse; fail-closed protects resources but rejects legitimate calls. Monitor allow/deny rates, store latency, hot keys, and clock anomalies. Sliding-window counters are a useful alternative when the contract is requests per rolling interval rather than a burst-capable rate.

[ASCII explanation](explanation.md)
