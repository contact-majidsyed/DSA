# Design a Notification System

Difficulty: **MEDIUM**

## Question

Design a service that sends notifications through email, SMS, or push while supporting retries and user preferences.

## Inputs to the system

Recipient, channel, message template, parameters, and an idempotency key.

## Expected behavior

A request identifier and observable delivery status; provider acceptance and confirmed delivery remain distinct.

Clarify traffic, latency, consistency, availability, and scope before proposing an architecture. There is no single exact-output design answer.

## Example scenario 1

**Input:** A caller retries the same notification with the same idempotency key.

**Expected behavior:** The service recognizes the duplicate request and avoids creating a second logical delivery.

## Example scenario 2

**Input:** A delivery provider temporarily rejects a request.

**Expected behavior:** The service records the attempt, retries with backoff, and exposes the eventual result.

Prepare requirements, APIs, data model, architecture, failure handling, and trade-offs. Then compare with the [reference approach](solution.md) and [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
