# Design a Notification System: Explanation

```text
API -> Database + Outbox -> Queue -> Channel workers -> Providers
                            |                            |
                            v                            v
                       Retry / DLQ                 Status callbacks
```

The outbox closes the gap between saving a request and publishing work. Queues absorb bursts, while workers handle channel-specific delivery and retries. Separate request acceptance from final delivery, and explain how idempotency reduces duplicate sends.

## Practice follow-up

Choose one bottleneck and one failure mode. Explain what changes at higher traffic, what consistency you promise, and what you would measure to verify the design. These are design outlines, not deployed implementations.

[Reference approach](solution.md)
