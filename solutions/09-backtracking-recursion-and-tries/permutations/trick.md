# Permutations: Quick Recall

**Trick:** At every position, try every unused index. Undo both the path append and the used flag after returning.

**Key code:** `used[i] = false;`

**Looks like:** Choose 1 -> choose 2 -> choose 3 -> save [1,2,3]; undo 3 and 2 -> try [1,3,2].

**Remember:** Choose, explore, undo both.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
