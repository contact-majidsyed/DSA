# Design a Distributed Cache: Explanation

[Quick recall](trick.md)

```text
Application -> Router / partition map
                 |       |       |
               Node A  Node B  Node C
                 |
              Replica A
miss -> durable source -> fill cache with TTL
```

Partitioning distributes keys; replication copies a partition for availability. Neither alone solves hot keys or stale values. Explain the cache-miss path and the race between a source update and an older in-flight cache fill.

## Practice follow-up

Choose one bottleneck and one failure mode. Explain what changes at higher traffic, what consistency you promise, and what you would measure to verify the design. These are design outlines, not deployed implementations.

[Reference approach](solution.md)
