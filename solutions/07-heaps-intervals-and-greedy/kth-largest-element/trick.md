# Kth Largest Element in an Array: Quick Recall

**Trick:** Keep only the k largest values in a min-heap. Its smallest retained value is the kth largest, counting duplicates.

**Key code:** `if (heap.size() > k) heap.remove();`

**Looks like:** [3,2,1,5,6,4], k=2 -> retained values {5,6}; heap minimum=5.

**Remember:** Keep k; return the smallest kept.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
