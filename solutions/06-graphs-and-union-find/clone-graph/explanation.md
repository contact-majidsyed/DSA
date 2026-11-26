# Clone Graph

Difficulty: **MEDIUM** | Pattern: **BFS + identity map**

## Problem

Deep-copy the connected component reachable from a graph node, preserving neighbor order.

## ASCII walkthrough

```text
original: A -- B       clone: A' -- B'
          |    |              |     |
          C -- D              C' -- D'
map original identity -> cloned node
```

## How the code works

Create and remember each clone before traversing its neighbors so cycles terminate. For each original edge, connect the corresponding clones. Key by node identity so equal values do not merge distinct nodes.

[Java solution](Solution.java)

## Complexity

Time O(V + E); auxiliary space O(V); cloned output O(V + E).

## Edge cases and assumptions

Null; self-loop; cycles; nodes with equal values; no copied edge should point at an original node.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
