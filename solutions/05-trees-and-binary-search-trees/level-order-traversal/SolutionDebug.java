package practice.trees_and_binary_search_trees.level_order_traversal;

import java.util.*;

/** Binary Tree Level Order Traversal. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: root = [1,2,3,4,5]
    //   Output: [[1],[2,3],[4,5]]
    // Example 2:
    //   Input: root = []
    //   Output: []
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // FINAL RETURN is the collected levels; the null-root early return gives [] for Example 2.
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        // AFTER enqueue: queue=[1]. Queue displays run from front to back.
        queue.add(root);
        // ===== LOOP START L1: while loop =====
        while (!queue.isEmpty()) {
            // OUTER VISITS: size=1,2,2 for levels [1], [2,3], [4,5].
            // Freeze size now; children added in the inner loop belong to the NEXT level.
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            // ===== LOOP START L2: for loop =====
            for (int i = 0; i < size; i++) {
                // INNER VISITS: level 1 removes 1; level 2 removes 2 then 3; level 3 removes 4 then 5.
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                // After both child-enqueue lines: removing 1 leaves queue=[2,3];
                // removing 2 leaves [3,4,5]; removing 3 leaves [4,5]; removing 4 leaves [5]; removing 5 leaves [].
                if (node.right != null) queue.add(node.right);
            }
            // ===== LOOP END L2 =====
            // AFTER each level: result=[[1]], then [[1],[2,3]], then [[1],[2,3],[4,5]].
            result.add(level);
        }
        // ===== LOOP END L1 =====
        // FINAL RETURN is the collected levels; the null-root early return gives [] for Example 2.
        return result;
    }
}
