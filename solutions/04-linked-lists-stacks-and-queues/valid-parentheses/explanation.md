# Valid Parentheses

Difficulty: **LOW** | Pattern: **Stack**

## Problem

Determine whether a string containing only ()[]{} has balanced, correctly nested brackets.

## ASCII walkthrough

```text
input: ({[]})
read ( -> expect )
read { -> expect } before )
read [ -> expect ] before } before )
read ], }, ) -> pop each match -> empty
```

## How the code works

Push the closing bracket expected for each opener. Every closer must equal the top of the stack. After all characters, no expected closers may remain.

[Java solution](Solution.java)

## Complexity

Time O(n); auxiliary space O(n).

## Edge cases and assumptions

Empty string; unmatched opener; leading closer; crossed brackets such as ([)].

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
