# Meeting Rooms II

Difficulty: **MEDIUM** | Pattern: **Sorting + min-heap**

## Problem

Return the minimum rooms needed for meetings [start,end), with start < end. A room ending at a new meeting's start is free. Input is sorted in place.

## ASCII walkthrough

```text
meeting: [9,10) [9,12) [10,11)
room A:  [9,10)[10,11)
room B:  [9,------------12)
maximum active meetings = 2
```

## How the code works

Process meetings in start order. Remove all finished meetings from the min-heap, then add the new end time. Heap size now counts active meetings. The maximum active count is both a lower bound on rooms and achievable by reusing finished rooms.

[Java solution](Solution.java)

## Complexity

Time O(n log n); auxiliary space O(n).

## Edge cases and assumptions

Empty input; simultaneous starts; end equals next start; input order changes.

## Practice aloud

Explain why the algorithm is correct, trace the example, and state the complexity before coding it again without looking.
