# Design a URL Shortener: Explanation

[Quick recall](trick.md)

```text
Client -> Redirect API -> Cache
                       -> Mapping store (on miss)
                       -> Event queue -> Analytics
Creator -> Create API -> Unique code -> Mapping store
```

A cache hit avoids a database lookup, while the mapping store remains authoritative. Creating a code is a write path with a uniqueness requirement; redirecting is a read path optimized for latency. Explain how expiry and mapping updates invalidate cached entries.

## Practice follow-up

Choose one bottleneck and one failure mode. Explain what changes at higher traffic, what consistency you promise, and what you would measure to verify the design. These are design outlines, not deployed implementations.

[Reference approach](solution.md)
