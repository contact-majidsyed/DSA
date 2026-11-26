# Number of Islands

Difficulty: **MEDIUM**

## Question

Count components of 1 cells connected horizontally or vertically in a rectangular grid. This solution marks visited land as 0 in place.

## Input

A rectangular grid of characters '1' for land and '0' for water.

## Output

The number of land components connected horizontally or vertically.

## Example 1

```text
Input: grid = ["1100","1001","0011"]
Output: 2
```

The upper-left land and the right/lower-right land form separate islands.

## Example 2

```text
Input: grid = ["10","01"]
Output: 2
```

Diagonal contact does not join islands.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).
