# Design a Notification System: Quick Recall

**Trick:** Save the request and an outbox event together, then deliver asynchronously with retries and deduplication. Provider acceptance is not confirmed delivery.

**Key move:** Use a stable idempotency key across retries.

**Looks like:** request -> database + outbox -> queue -> worker -> provider; a timeout may leave acceptance uncertain.

**Remember:** Retry the delivery, not the logical request.

[Question](question.md) · [Full approach](solution.md) · [Explanation](explanation.md)
