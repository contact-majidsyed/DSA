package practice.trees_and_binary_search_trees.lowest_common_ancestor;

import java.util.*;

/** Lowest Common Ancestor of a Binary Tree. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: root = [3,5,1,6,2], p = node 6, q = node 2
    //   Output: node 5
    // Example 2:
    //   Input: root = [3,5,1,6,2], p = node 5, q = node 6
    //   Output: node 5
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    // RECURSION START: root=3, p=node 6, q=node 2. The left child is 5, with children 6 and 2.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BASE CASE: return a matched target reference or null for a missing child.
        // Calls at nodes 6 and 2 return themselves without visiting their children.
        if (root == null || root == p || root == q) return root;
        // RECURSIVE LEFT CALL: at root 5, left becomes node 6; at root 3, left eventually becomes node 5.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // RECURSIVE RIGHT CALL: at root 5, right becomes node 2; at root 3, subtree 1 returns null.
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // JOIN at node 5: left=6 and right=2 -> RETURN node 5. Both targets are assumed present.
        if (left != null && right != null) return root;
        // UNWIND at node 3: left=5,right=null -> FINAL RETURN node 5.
        // Example 2 p=5,q=6: matching node 5 is already the answer.
        return left != null ? left : right;
    }
}
