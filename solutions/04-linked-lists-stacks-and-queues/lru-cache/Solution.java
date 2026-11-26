package practice.linked_lists_stacks_and_queues.lru_cache;

import java.util.*;

/** LRU Cache. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class LRUCache {
        private static class Node {
            int key, value;
            Node prev, next;
            Node(int key, int value) { this.key = key; this.value = value; }
        }
        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(0, 0), tail = new Node(0, 0);
        public LRUCache(int capacity) {
            if (capacity < 0) throw new IllegalArgumentException("Negative capacity");
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            remove(node);
            addFirst(node);
            return node.value;
        }
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
                Node victim = tail.prev;
                remove(victim);
                map.remove(victim.key);
            }
        }
    }
}
