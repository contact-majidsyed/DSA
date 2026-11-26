# Combination Sum: Quick Recall

**Trick:** For distinct positive candidates, recurse with i to allow reuse; never move to earlier indices, so [2,2,3] and [3,2,2] are not both generated.

**Key code:** `search(candidates, remaining - candidates[i], i, path, result);`

**Looks like:** target=7, candidates=[2,3,6,7]: remaining 7->5->3->0 builds [2,2,3]; another branch builds [7].

**Remember:** Same index to reuse; never backward.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
