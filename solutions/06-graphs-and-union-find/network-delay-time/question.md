# Network Delay Time

Difficulty: **HIGH**

## Question

Given directed edges [from,to,weight], vertices 1..n, and source k, return the maximum shortest-path distance, or -1 if any node is unreachable. Weights are nonnegative.

## Input

Directed edges times = [from,to,weight], n vertices numbered 1..n, and source k; weights are nonnegative.

## Output

The time until all vertices receive the signal, or -1 if any is unreachable.

## Example 1

```text
Input: times = [[1,2,2],[1,3,5],[2,3,1]], n = 3, k = 1
Output: 3
```

Vertex 3 receives the signal via vertex 2 in time 3.

## Example 2

```text
Input: times = [[1,2,1]], n = 3, k = 1
Output: -1
```

Vertex 3 cannot be reached.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
