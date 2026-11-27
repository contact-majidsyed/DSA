package practice.trees_and_binary_search_trees.validate_bst;

import java.util.*;

/** Validate Binary Search Tree. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: root = [2,1,3]
    //   Output: true
    // Example 2:
    //   Input: root = [5,3,8,null,null,4]
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    public boolean isValidBST(TreeNode root) {
        // RECURSION ENTRY: root 2 starts with long bounds (MIN,MAX); all int values fit strictly inside.
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean valid(TreeNode node, long low, long high) {
        // BASE CASE: missing child returns true.
        if (node == null) return true;
        // Example 1 checks: node 2 in (MIN,MAX), node 1 in (MIN,2), node 3 in (2,MAX).
        // Example 2 reaches node 4 in range (5,8): 4<=5 -> EARLY RETURN false.
        if (node.val <= low || node.val >= high) return false;
        // RECURSIVE CALLS: tighten upper bound for left, lower bound for right.
        // Example 1: both children return true -> root returns true.
        // Example 2: false propagates upward; && skips the right call after a false left result.
        return valid(node.left, low, node.val) && valid(node.right, node.val, high);
    }
}
