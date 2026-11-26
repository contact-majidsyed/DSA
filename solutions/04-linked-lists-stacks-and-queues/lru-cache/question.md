# LRU Cache

Difficulty: **HIGH**

## Question

Implement integer-key/value get and put with least-recently-used eviction. Missing keys return -1. Capacity must be nonnegative.

## Input

A nonnegative capacity and a sequence of get(key) and put(key,value) operations.

## Output

get returns a stored value or -1; put has no return value. Evict the least recently used key when necessary.

## Example 1

```text
Input: capacity = 2; put(1,1); put(2,2); get(1); put(3,3); get(2); get(3)
Output: get results: [1,-1,3]
```

Accessing key 1 makes key 2 least recent, so inserting key 3 evicts key 2.

## Example 2

```text
Input: capacity = 0; put(1,1); get(1)
Output: get results: [-1]
```

A zero-capacity cache retains no entries.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
