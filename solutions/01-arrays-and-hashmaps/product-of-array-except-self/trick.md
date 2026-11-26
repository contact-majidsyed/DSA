# Product of Array Except Self: Quick Recall

**Trick:** Store products to the left, then multiply by products to the right; update the running product after using it.

**Key code:** `result[i] *= suffix;`

**Looks like:** [1,2,3,4] -> left products [1,1,2,6] -> final [24,12,8,6].

**Remember:** Left of me times right of me.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
