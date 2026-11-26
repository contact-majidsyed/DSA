# Task Scheduler

Difficulty: **HIGH**

## Question

Return the shortest number of unit time slots to execute uppercase A-Z tasks with at least n intervening slots between identical tasks. n >= 0.

## Input

Uppercase task labels and nonnegative cooldown n; every task takes one time slot.

## Output

The minimum total slots, including idle slots, with at least n slots between identical tasks.

## Example 1

```text
Input: tasks = [A,A,A,B,B,B], n = 2
Output: 8
```

One schedule is A B idle A B idle A B.

## Example 2

```text
Input: tasks = [A,A,A,B,B,B], n = 0
Output: 6
```

No idle slots are necessary.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
