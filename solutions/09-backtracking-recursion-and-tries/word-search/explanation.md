# Word Search

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Grid DFS + backtracking**

## Problem

Determine whether a word follows horizontal/vertical neighbors in a rectangular grid without reusing a cell. Empty word is considered found.

## ASCII walkthrough

```text
A B C E
S F C S
A D E E
ABCCED path:
(0,0)->(0,1)->(0,2)->(1,2)->(2,2)->(2,1)
```

## How the code works

Try every cell as a start. Each recursion matches the next character and marks the current cell for this path. Restore the mark when returning, even on success. The separate used grid preserves the board and avoids assuming an unused sentinel character.

[Java solution](Solution.java)

## Complexity

For R rows, C columns, word length L: time O(R*C*4^L) conservative upper bound; auxiliary space O(R*C + min(L,R*C)) for visited grid and stack.

## Edge cases and assumptions

Empty word; empty grid; forbidden cell reuse; repeated letters; board preserved.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
