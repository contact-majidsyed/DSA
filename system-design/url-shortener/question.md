# Design a URL Shortener

Difficulty: **LOW**

## Question

Design a service that creates short links and redirects visitors to their destinations.

## Inputs to the system

Destination URLs, optional custom aliases, expiry settings, and redirect requests.

## Expected behavior

A short URL on creation; a redirect or a clear missing/expired response on lookup.

Clarify traffic, latency, consistency, availability, and scope before proposing an architecture. There is no single exact-output design answer.

## Example scenario 1

**Input:** Create a link for https://example.com/articles/intro, then visit its short code.

**Expected behavior:** The service returns a unique short link and later redirects to the original URL.

## Example scenario 2

**Input:** Two clients request the same custom alias for different destinations.

**Expected behavior:** At most one mapping owns the alias; the other request receives a conflict response.

Prepare requirements, APIs, data model, architecture, failure handling, and trade-offs. Then compare with the [reference approach](solution.md) and [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
