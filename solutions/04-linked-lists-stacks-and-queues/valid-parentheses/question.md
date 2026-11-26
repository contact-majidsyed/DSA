# Valid Parentheses

Difficulty: **LOW**

## Question

Determine whether a string containing only ()[]{} has balanced, correctly nested brackets.

## Input

A string containing only parentheses, square brackets, and braces.

## Output

true if every bracket is correctly matched and nested; otherwise false.

## Example 1

```text
Input: s = "({[]})"
Output: true
```

Closing brackets match in reverse nesting order.

## Example 2

```text
Input: s = "([)]"
Output: false
```

The closing parenthesis appears before the square bracket closes.

Try solving the problem before opening the [Java solution](Solution.java) or [ASCII explanation](explanation.md).

[Quick recall hint](trick.md) — open after trying the question.
