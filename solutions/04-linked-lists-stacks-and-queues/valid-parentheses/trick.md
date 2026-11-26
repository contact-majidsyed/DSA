# Valid Parentheses: Quick Recall

**Trick:** Push the closer you expect. Each closing bracket must match the top; the stack must be empty at the end.

**Key code:** `if (c == '(') stack.push(')');`

**Looks like:** After reading "([{", expected closers top-first are [},],)] -> next must be }.

**Remember:** Last opened, first closed.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
