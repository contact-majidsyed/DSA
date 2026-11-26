# Design a Rate Limiter

Difficulty: **MEDIUM**

## Question

Design a distributed service that allows or rejects requests according to a configured rate and burst limit.

## Inputs to the system

Client identity, request cost, time, and a rate-limit policy.

## Expected behavior

An allow/deny decision, remaining quota, and a retry hint when appropriate.

Clarify traffic, latency, consistency, availability, and scope before proposing an architecture. There is no single exact-output design answer.

## Example scenario 1

**Input:** A full bucket holds three tokens; four requests of cost one arrive before any refill.

**Expected behavior:** The first three requests are allowed; the fourth is denied.

## Example scenario 2

**Input:** An empty bucket refills at one token per second; a cost-one request arrives after one second.

**Expected behavior:** The request is allowed if no other request has consumed the new token.

Prepare requirements, APIs, data model, architecture, failure handling, and trade-offs. Then compare with the [reference approach](solution.md) and [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
