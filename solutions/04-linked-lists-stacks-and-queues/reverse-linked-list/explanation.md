# Reverse Linked List

[Question and examples](question.md)

Difficulty: **LOW** | Pattern: **Pointer manipulation**

## Problem

Reverse a singly linked list in place and return its new head.

## ASCII walkthrough

```text
before: null    1 -> 2 -> 3 -> null
        prev   cur
step:   null <- 1    2 -> 3 -> null
               prev cur
after:  null <- 1 <- 2 <- 3 (new head)
```

## How the code works

Save the next node before overwriting the link. Point current backward, advance prev to current, and advance current to the saved next node. At the end prev is the new head.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(1).

## Edge cases and assumptions

Null head; one node; input links are changed.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
