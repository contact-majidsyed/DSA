# Product of Array Except Self

Difficulty: **MEDIUM**

## Question

Return each element's product excluding itself without division. Assume prefix, suffix, and result products fit int.

## Input

An integer array nums.

## Output

An array where result[i] is the product of all values except nums[i].

## Example 1

```text
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

For index 0, the product is 2 * 3 * 4 = 24.

## Example 2

```text
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

Only the position containing zero has a nonzero product.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.

[Comment-only debug walkthrough](SolutionDebug.java)
