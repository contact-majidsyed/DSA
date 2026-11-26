# Design a Chat Application

Difficulty: **MEDIUM**

## Reference approach

Support one-to-one and group messaging with history and offline delivery. Clarify group size, ordering requirements, multi-device behavior, and encryption expectations.

Expose authenticated WebSocket sessions for live delivery and HTTP APIs for conversation history. Messages carry a client-generated deduplication ID, conversation ID, sender, content, and server-assigned per-conversation sequence. Store messages durably before acknowledging acceptance.

Route conversation writes to an owning partition or ordered log. A single ordering authority per conversation assigns sequence numbers; wall-clock timestamps alone do not guarantee order. Publish accepted messages to fan-out workers, which locate online sessions and notify offline users.

On reconnect, clients request messages after their last received sequence and deduplicate by message ID. Store read receipts separately and allow them to update asynchronously. Presence is ephemeral state with heartbeats and expiry, not a guarantee of reachability.

Partition history by conversation and sequence, page old messages, and move attachments to object storage referenced by metadata. Very large groups require fan-out trade-offs: pushing to every member costs write work, while fetching on demand costs read work. Handle reconnect storms with backoff and bounded queues. Use transport encryption and access checks; end-to-end encryption changes search, moderation, and key-management designs.

[ASCII explanation](explanation.md)
