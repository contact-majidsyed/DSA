# Linked List Cycle

Difficulty: **LOW**

## Question

Determine whether a singly linked list has a cycle, without modifying it.

## Input

A linked-list head. In examples only, pos is the index the tail connects to, or -1 for no cycle.

## Output

true if following next pointers can revisit a node; otherwise false. pos is not a method argument.

## Example 1

```text
Input: head = [3,2,0,-4], pos = 1
Output: true
```

The tail points to the node containing 2, creating a cycle.

## Example 2

```text
Input: head = [1,2], pos = -1
Output: false
```

The tail points to null.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
