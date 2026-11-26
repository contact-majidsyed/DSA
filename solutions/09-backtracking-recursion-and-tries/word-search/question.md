# Word Search

Difficulty: **MEDIUM**

## Question

Determine whether a word follows horizontal/vertical neighbors in a rectangular grid without reusing a cell. Empty word is considered found.

## Input

A rectangular character board and a word.

## Output

true if the word follows horizontal/vertical neighbors without reusing a cell.

## Example 1

```text
Input: board = ["ABCE","SFCS","ADEE"], word = "ABCCED"
Output: true
```

A path runs through cells (0,0),(0,1),(0,2),(1,2),(2,2),(2,1).

## Example 2

```text
Input: board = ["ABCE","SFCS","ADEE"], word = "ABCB"
Output: false
```

Completing this path would require reusing a B cell.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
