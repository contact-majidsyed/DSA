# Design a URL Shortener

Difficulty: **LOW**

## Reference approach

Create short URLs and redirect them to the original destination. Clarify traffic, retention, custom aliases, and analytics requirements before choosing scale targets.

API: `POST /links` accepts a destination and optional alias; `GET /{code}` redirects. Store `code -> destination, owner, created_at, expires_at` with a unique constraint on code. Validate allowed destination schemes.

Generate a random Base62 code and retry on uniqueness conflicts, or encode an allocated unique ID. Random codes reduce easy enumeration but still need collision handling. Persist the mapping before acknowledging creation. On redirect, check a cache first, read the durable store on a miss, and cache the result with a TTL bounded by link expiry.

Partition mappings by code when volume demands it. Redirect traffic is mostly reads, so cache popular codes and use read replicas where stale reads are acceptable. Send analytics asynchronously so it does not delay redirects. Choose temporary versus permanent redirects based on whether mappings may change.

For cache outages, use bounded database fallback and load shedding. Protect creation and redirects from abusive traffic; consider malicious destination reporting. Expired or unknown links return a clear not-found response. Trade off random-code length, collision probability, and usability.

[ASCII explanation](explanation.md)
