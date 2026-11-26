# Design a Distributed Cache: Quick Recall

**Trick:** Separate partitioning, replication, and expiry: they solve different problems. Plan how misses and failures affect the source store.

**Key move:** Coalesce concurrent misses for the same key and bound fallback load.

**Looks like:** 100 requests miss key K -> one coordinated source fetch -> fill K -> waiting requests reuse the value.

**Remember:** A cache outage must not become a database outage.

[Question](question.md) · [Full approach](solution.md) · [Explanation](explanation.md)
