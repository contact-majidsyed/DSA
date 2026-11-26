# Daily Temperatures

Difficulty: **MEDIUM** | Pattern: **Monotonic stack**

## Problem

For each day return how many days until a strictly warmer temperature, or zero if none.

## ASCII walkthrough

```text
temps:  [73,74,75,71,69,72,76]
indices:  0  1  2  3  4  5  6
at day 5 (72): resolve day 4 -> 1, day 3 -> 2
at day 6 (76): resolve day 5 -> 1, day 2 -> 4
answer: [1,1,4,2,1,1,0]
```

## How the code works

Keep unresolved indices with non-increasing temperatures. A warmer day resolves every colder index at the top; each answer is the index distance. Each index is pushed and popped at most once.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(n), output O(n).

## Edge cases and assumptions

Equal temperatures are not warmer; decreasing sequence; empty input.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
