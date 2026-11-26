# Design a Rate Limiter: Explanation

```text
Request -> Gateway -> Atomic bucket check -> Allow -> Service
                                      \-> Deny (429)
bucket: tokens=min(capacity, tokens + elapsed*rate)
        if tokens >= cost: subtract cost and allow
```

The correctness boundary is the atomic state update. Two gateways must not both spend the same token. The bucket capacity controls bursts; refill rate controls sustained traffic. Walk through a full bucket, a burst that empties it, and a request after partial refill.

## Practice follow-up

Choose one bottleneck and one failure mode. Explain what changes at higher traffic, what consistency you promise, and what you would measure to verify the design. These are design outlines, not deployed implementations.

[Reference approach](solution.md)
