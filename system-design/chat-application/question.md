# Design a Chat Application

Difficulty: **MEDIUM**

## Question

Design a chat service supporting live messages, history, group conversations, and reconnecting clients.

## Inputs to the system

Authenticated participants, conversation IDs, messages, and client deduplication IDs.

## Expected behavior

Durably accepted messages, live delivery when possible, and ordered history for recovery.

Clarify traffic, latency, consistency, availability, and scope before proposing an architecture. There is no single exact-output design answer.

## Example scenario 1

**Input:** A connected sender sends a message to a connected recipient.

**Expected behavior:** The message is persisted, acknowledged, and delivered with a stable ID and conversation sequence.

## Example scenario 2

**Input:** A recipient disconnects after sequence 10 and reconnects after messages 11 through 15 arrive.

**Expected behavior:** The client retrieves the missing messages and deduplicates any repeated delivery.

Prepare requirements, APIs, data model, architecture, failure handling, and trade-offs. Then compare with the [reference approach](solution.md) and [ASCII explanation](explanation.md).
