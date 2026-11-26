package practice.trees_and_binary_search_trees.maximum_depth;

import java.util.*;

/** Maximum Depth of Binary Tree. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
