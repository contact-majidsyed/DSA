# Design a Distributed Cache

Difficulty: **HIGH**

## Question

Design a distributed key-value cache with bounded memory, expiration, and behavior defined for node failures.

## Inputs to the system

get, set, and delete operations with keys, values, and optional TTLs.

## Expected behavior

Values on valid hits, misses for absent or expired keys, and documented write/failure semantics.

Clarify traffic, latency, consistency, availability, and scope before proposing an architecture. There is no single exact-output design answer.

## Example scenario 1

**Input:** Set key item:1 to a value with a ten-second TTL, then read it after eleven seconds.

**Expected behavior:** The read is a miss even if background cleanup has not physically removed the value.

## Example scenario 2

**Input:** A node owning cached keys fails during a read.

**Expected behavior:** The service uses a replica or returns a controlled miss/error according to its contract; stale-read and recovery behavior must be explained.

Prepare requirements, APIs, data model, architecture, failure handling, and trade-offs. Then compare with the [reference approach](solution.md) and [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
