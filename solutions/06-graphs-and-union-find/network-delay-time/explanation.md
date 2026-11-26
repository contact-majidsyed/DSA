# Network Delay Time

Difficulty: **HIGH** | Pattern: **Dijkstra + min-heap**

## Problem

Given directed edges [from,to,weight], vertices 1..n, and source k, return the maximum shortest-path distance, or -1 if any node is unreachable. Weights are nonnegative.

## ASCII walkthrough

```text
A --2--> B --1--> C
 \------5-------> C
start A: A=0, B=2, C=5
visit B: C=min(5,2+1)=3
maximum distance = 3
```

## How the code works

Always expand the smallest tentative distance. Relax outgoing edges if the new route is shorter. The heap may contain old entries, so skip any entry whose distance no longer matches. Nonnegative weights are essential to Dijkstra's guarantee.

[Java solution](Solution.java)

## Complexity

Time O(V + E log(E + 1)) for this lazy heap implementation; auxiliary space O(V + E). For simple graphs this is commonly written O((V + E) log V).

## Edge cases and assumptions

Unreachable vertices; one vertex; zero weights; multiple routes; valid source and n >= 1 assumed; long distances avoid int overflow.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
