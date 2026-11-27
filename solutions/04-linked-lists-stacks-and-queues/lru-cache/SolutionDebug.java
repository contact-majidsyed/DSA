package practice.linked_lists_stacks_and_queues.lru_cache;

import java.util.*;

/** LRU Cache. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: capacity = 2; put(1,1); put(2,2); get(1); put(3,3); get(2); get(3)
    //   Output: get results: [1,-1,3]
    // Example 2:
    //   Input: capacity = 0; put(1,1); get(1)
    //   Output: get results: [-1]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class LRUCache {
        private static class Node {
            int key, value;
            Node prev, next;
            Node(int key, int value) { this.key = key; this.value = value; }
        }
        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(0, 0), tail = new Node(0, 0);
        // OPERATION START: capacity=2; connect empty sentinels HEAD <-> TAIL.
        // This solution has no loops or recursion: follow each operation and pointer update.
        public LRUCache(int capacity) {
            if (capacity < 0) throw new IllegalArgumentException("Negative capacity");
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }
        private void remove(Node node) {
            // REMOVE STEP 1: for HEAD<->2<->1<->TAIL, remove node 1 by linking 2.next to TAIL.
            node.prev.next = node.next;
            // REMOVE STEP 2: TAIL.prev becomes node 2. Node 1 is now detached from the list.
            node.next.prev = node.prev;
        }
        private void addFirst(Node node) {
            // ADD-FIRST STEP 1: when reattaching node 1, node.next becomes old front node 2.
            node.next = head.next;
            // ADD-FIRST STEP 2: node 1.prev becomes HEAD.
            node.prev = head;
            // ADD-FIRST STEP 3: old front node 2.prev becomes node 1.
            head.next.prev = node;
            // ADD-FIRST STEP 4: HEAD.next becomes node 1 -> HEAD<->1<->2<->TAIL.
            head.next = node;
        }
        // OPERATION START: get(1) after put(1,1),put(2,2) moves 1 to the front and returns 1.
        // After put(3,3), get(2) returns -1; get(3) returns 3.
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            remove(node);
            addFirst(node);
            return node.value;
        }
        // OPERATION START: after put(1,1), order=[1]; after put(2,2), order=[2,1], most recent first.
        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                remove(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
            }
            addFirst(node);
            if (map.size() > capacity) {
                // put(3,3) after get(1): order first becomes [3,1,2], map.size=3>capacity=2.
                // victim=node 2; removing it from list and map leaves [3,1].
                // For capacity 0, each inserted node is immediately evicted.
                Node victim = tail.prev;
                remove(victim);
                map.remove(victim.key);
            }
        }
    }
}
