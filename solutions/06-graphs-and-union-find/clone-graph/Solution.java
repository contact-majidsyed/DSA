package practice.graphs_and_union_find.clone_graph;

import java.util.*;

/** Clone Graph. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class Node {
        public int val;
        public List<Node> neighbors = new ArrayList<>();
        public Node(int val) { this.val = val; }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> copies = new IdentityHashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        copies.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node original = queue.remove();
            for (Node neighbor : original.neighbors) {
                if (!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                copies.get(original).neighbors.add(copies.get(neighbor));
            }
        }
        return copies.get(node);
    }
}
