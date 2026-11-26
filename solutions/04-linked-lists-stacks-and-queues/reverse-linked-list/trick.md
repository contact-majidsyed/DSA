# Reverse Linked List: Quick Recall

**Trick:** Save the next node before reversing the current link, or you lose the rest of the list.

**Key code:** `ListNode next = current.next;`

**Looks like:** prev=null, current=1->2->3: save 2, point 1 to null, then advance prev=1 and current=2.

**Remember:** Save next before changing next.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
