package practice.linked_lists_stacks_and_queues.linked_list_cycle;

import java.util.*;

/** Linked List Cycle. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
