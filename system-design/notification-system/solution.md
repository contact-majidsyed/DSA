# Design a Notification System

Difficulty: **MEDIUM**

## Reference approach

Deliver email, SMS, and push notifications while honoring user preferences. Clarify urgency, scheduled delivery, throughput, ordering, and provider delivery guarantees.

API: `POST /notifications` accepts an idempotency key, recipient, template, channel choices, and parameters. Store a notification record and a delivery record per recipient/channel. States include pending, sending, accepted-by-provider, delivered when confirmed, and failed.

Use a transactional outbox to commit the request and its pending event together. An outbox publisher sends work to queues. Workers check preferences, render templates, enforce provider rate limits, and send. Store attempt IDs and provider references; consume authenticated provider callbacks to update status.

Retry transient failures with exponential backoff and jitter, respecting provider retry guidance. Route permanent failures and exhausted retries to a dead-letter queue for inspection. Use idempotency keys and provider deduplication where available: a timeout after provider acceptance can otherwise cause duplicate messages, so do not promise universal exactly-once delivery.

Separate queues by channel and priority so a slow provider does not block urgent work. Partition by recipient if per-recipient ordering is required. Track queue age, acceptance latency, retries, delivery status, and suppression rates. Minimize stored personal content and restrict access. A provider's acceptance is not proof that the user received the message.

[ASCII explanation](explanation.md)
