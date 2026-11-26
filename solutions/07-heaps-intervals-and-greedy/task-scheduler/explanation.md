# Task Scheduler

[Question and examples](question.md)

Difficulty: **HIGH** | Pattern: **Greedy frequency formula**

## Problem

Return the shortest number of unit time slots to execute uppercase A-Z tasks with at least n intervening slots between identical tasks. n >= 0.

## ASCII walkthrough

```text
tasks: A A A B B B, cooldown=2
A B _ | A B _ | A B
(max-1) full frames + tied final tasks
(3-1)*(2+1)+2 = 8 slots
```

## How the code works

The most frequent tasks determine the necessary spacing. Form max-1 blocks of length n+1, then append the tied most-frequent tasks. Other tasks fill gaps. If there are more tasks than this frame can hold, the task count itself is the bound; the optimal length is the maximum of the two.

[Java solution](Solution.java)

## Complexity

Time O(number of tasks + 26); auxiliary space O(1).

## Edge cases and assumptions

Empty tasks; zero cooldown; one repeated task; many tied frequencies; long result avoids int overflow.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
