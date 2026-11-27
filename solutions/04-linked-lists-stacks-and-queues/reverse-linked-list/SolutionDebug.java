package practice.linked_lists_stacks_and_queues.reverse_linked_list;

import java.util.*;

/** Reverse Linked List. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: head = [1,2,3]
    //   Output: [3,2,1]
    // Example 2:
    //   Input: head = []
    //   Output: []
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public ListNode reverseList(ListNode head) {
        // START for 1->2->3: prev=null, current=node 1. Values below identify these distinct nodes.
        ListNode prev = null, current = head;
        // ===== LOOP START L1: while loop =====
        while (current != null) {
            // Visits current=1,2,3 -> saved next=2,3,null respectively. Save before overwriting the link.
            ListNode next = current.next;
            // AFTER rewiring: visit 1 gives 1->null; visit 2 gives 2->1->null; visit 3 gives 3->2->1->null.
            current.next = prev;
            // AFTER assignment: prev=node 1, then node 2, then node 3.
            prev = current;
            // AFTER assignment: current=node 2, then node 3, then null. Null ends the loop.
            current = next;
        }
        // ===== LOOP END L1 =====
        // RETURN node 3, the head of [3,2,1]. For the empty second example, the loop is skipped and null returns.
        return prev;
    }
}
