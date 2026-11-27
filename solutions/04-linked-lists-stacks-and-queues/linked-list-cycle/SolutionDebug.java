package practice.linked_lists_stacks_and_queues.linked_list_cycle;

import java.util.*;

/** Linked List Cycle. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: head = [3,2,0,-4], pos = 1
    //   Output: true
    // Example 2:
    //   Input: head = [1,2], pos = -1
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
    public boolean hasCycle(ListNode head) {
        // Example 1: nodes 3->2->0->-4, with -4.next pointing back to node 2.
        // START slow=fast=node 3. Compare references, not the stored values.
        ListNode slow = head, fast = head;
        // ===== LOOP START L1: while loop =====
        while (fast != null && fast.next != null) {
            // After this line on visits 1,2,3: slow=node 2, node 0, node -4.
            slow = slow.next;
            // After this line on visits 1,2,3: fast=node 0, node 2, node -4.
            fast = fast.next.next;
            // EARLY RETURN on visit 3: both references point to the same node -4 -> true.
            if (slow == fast) return true;
        }
        // ===== LOOP END L1 =====
        // Example 2: 1->2->null. One visit makes slow=2,fast=null; next condition fails -> false.
        return false;
    }
}
