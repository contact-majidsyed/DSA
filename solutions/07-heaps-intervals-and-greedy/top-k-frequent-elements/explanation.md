# Top K Frequent Elements

[Quick recall](trick.md)

[Question and examples](question.md)

Difficulty: **MEDIUM** | Pattern: **Frequency map + bounded heap**

## Problem

Return k values with the greatest frequencies; if frequencies tie, any valid selection and order is accepted. Require 0 <= k <= unique count.

## ASCII walkthrough

```text
[1,1,1,2,2,3], k=2
counts: 1->3, 2->2, 3->1
retain two highest frequencies
answer set = {1,2}
```

## How the code works

Count occurrences first. Build a min-heap ordered by those fixed frequencies. Remove the least frequent whenever size exceeds k. The result order is unspecified and does not represent descending frequency.

[Java solution](Solution.java)

## Complexity

Expected time O(n + U log(k + 1)), U distinct values; auxiliary space O(U + k).

## Edge cases and assumptions

k = 0; negative values; ties; all values identical.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.

[Comment-only debug walkthrough](SolutionDebug.java)
