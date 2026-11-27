package practice.trees_and_binary_search_trees.maximum_depth;

import java.util.*;

/** Maximum Depth of Binary Tree. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: root = [1,2,3,4]
    //   Output: 3
    // Example 2:
    //   Input: root = []
    //   Output: 0
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    // RECURSION START: Example 1 tree has root 1, children 2 and 3, and 2.left=4.
    // Calls descend 1 -> 2 -> 4 -> null, then unwind before visiting siblings.
    public int maxDepth(TreeNode root) {
        // BASE CASE: every missing child returns 0 to its caller.
        if (root == null) return 0;
        // RECURSIVE CALLS + RETURN: evaluate the left child, then the right child.
        // Node 4: 1+max(0,0)=1. Node 2: 1+max(1,0)=2. Node 3: 1+max(0,0)=1.
        // Node 1: 1+max(2,1)=3 -> FINAL RETURN. Each call has its own root reference.
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
