# Top K Frequent Elements: Quick Recall

**Trick:** Count values first, then keep k keys in a min-heap ordered by frequency, not numeric value.

**Key code:** `PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));`

**Looks like:** [1,1,1,2,2,3] -> counts {1:3,2:2,3:1}; k=2 keeps values {1,2}.

**Remember:** Rank counts, return values.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
