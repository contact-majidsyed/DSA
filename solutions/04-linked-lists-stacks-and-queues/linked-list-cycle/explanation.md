# Linked List Cycle

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **Fast / slow pointers**

## Problem

Determine whether a singly linked list has a cycle, without modifying it.

## ASCII walkthrough

```text
1 -> 2 -> 3 -> 4
          ^    |
          +----+
slow: 1 step per turn
fast: 2 steps per turn
inside cycle, fast eventually catches slow
```

## How the code works

Compare node identity, not values. If fast reaches null, the list ends. In a cycle, the relative distance changes by one each step, so the pointers must eventually meet.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Null head; self-cycle; duplicate values without a cycle.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
