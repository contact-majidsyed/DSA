# Design a Chat Application: Explanation

[Quick recall](trick.md)

```text
Sender -> WebSocket gateway -> Conversation partition -> Message store
                                         |
                                         v
                                  Fan-out / event log
                                    /          \
                          Online sessions    Offline notification
Reconnect -> fetch messages after last sequence
```

Persist first, then acknowledge and deliver. Delivery can be retried, so clients deduplicate. Per-conversation sequence numbers let clients detect gaps and recover history; they do not imply a global order across conversations.

## Practice follow-up

Choose one bottleneck and one failure mode. Explain what changes at higher traffic, what consistency you promise, and what you would measure to verify the design. These are design outlines, not deployed implementations.

[Reference approach](solution.md)
