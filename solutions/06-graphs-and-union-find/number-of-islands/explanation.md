# Number of Islands

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Iterative DFS**

## Problem

Count components of 1 cells connected horizontally or vertically in a rectangular grid. This solution marks visited land as 0 in place.

## ASCII walkthrough

```text
1 1 0 0      A A . .
1 0 0 1  ->  A . . B
0 0 1 1      . . B B
A and B are separate components -> 2
```

## How the code works

Each still-unvisited land cell starts a new island. Explore all its neighbors and mark them before pushing, preventing duplicate pushes. An explicit stack avoids recursive call-stack limits. Diagonal contact does not connect islands.

[Java solution](Solution.java)

## Complexity

Time O(rows * cols); auxiliary space O(rows * cols) worst case.

## Edge cases and assumptions

Empty grid; all water; diagonal land; one large island; grid is mutated.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
