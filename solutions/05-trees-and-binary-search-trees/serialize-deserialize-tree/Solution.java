package practice.trees_and_binary_search_trees.serialize_deserialize_tree;

import java.util.*;

/** Serialize and Deserialize Binary Tree. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        write(root, out);
        return out.toString();
    }
    private void write(TreeNode node, StringBuilder out) {
        if (node == null) { out.append("#,"); return; }
        out.append(node.val).append(',');
        write(node.left, out);
        write(node.right, out);
    }
    public TreeNode deserialize(String data) {
        return read(Arrays.asList(data.split(",")).iterator());
    }
    private TreeNode read(Iterator<String> tokens) {
        String token = tokens.next();
        if (token.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = read(tokens);
        node.right = read(tokens);
        return node;
    }
}
