package practice.graphs_and_union_find.clone_graph;

import java.util.*;

/** Clone Graph. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: adjacency = {1:[2], 2:[1]}
    //   Output: clone adjacency = {1:[2], 2:[1]}
    // Example 2:
    //   Input: node = null
    //   Output: null
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();
        public Node(int val) { this.val = val; }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> copies = new IdentityHashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        // START with original node 1: copies={1:clone1}, queue will contain [1].
        // Labels describe nodes in this example; the actual map keys are object identities.
        copies.put(node, new Node(node.val));
        queue.add(node);
        // ===== LOOP START L1: while loop =====
        while (!queue.isEmpty()) {
            // OUTER VISITS dequeue original 1, then original 2.
            Node original = queue.remove();
            // ===== LOOP START L2: for loop =====
            for (Node neighbor : original.neighbors) {
                // Neighbor of 1 is 2: missing -> allocate clone2 and enqueue original 2.
                // Neighbor of 2 is 1: already copied -> do not allocate or enqueue it again.
                if (!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // After visiting 1: clone1.neighbors=[clone2]. After 2: clone2.neighbors=[clone1].
                copies.get(original).neighbors.add(copies.get(neighbor));
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        // RETURN clone1; no cloned neighbor points to an original node. Null input returns null before the loops.
        return copies.get(node);
    }
}
