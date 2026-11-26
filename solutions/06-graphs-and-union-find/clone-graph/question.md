# Clone Graph

Difficulty: **MEDIUM**

## Question

Deep-copy the connected component reachable from a graph node, preserving neighbor order.

## Input

A reference to a node in a graph, or null. Examples show adjacency lists of uniquely labeled nodes.

## Output

A deep copy of the reachable component, with all-new nodes and preserved edges.

## Example 1

```text
Input: adjacency = {1:[2], 2:[1]}
Output: clone adjacency = {1:[2], 2:[1]}
```

The structure matches, but neither returned node is an original node.

## Example 2

```text
Input: node = null
Output: null
```

An empty graph has no node to clone.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
