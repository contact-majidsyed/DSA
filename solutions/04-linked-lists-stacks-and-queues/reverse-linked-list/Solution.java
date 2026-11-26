package practice.linked_lists_stacks_and_queues.reverse_linked_list;

import java.util.*;

/** Reverse Linked List. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
