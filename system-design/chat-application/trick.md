# Design a Chat Application: Quick Recall

**Trick:** Persist messages before acknowledging; use per-conversation sequence numbers and stable IDs to recover gaps and deduplicate retries.

**Key move:** On reconnect, fetch messages after the last received sequence.

**Looks like:** Client last saw 10; server has 11..15 -> fetch 11..15, ignore any IDs already received.

**Remember:** Save first; recover by sequence.

[Question](question.md) · [Full approach](solution.md) · [Explanation](explanation.md)
