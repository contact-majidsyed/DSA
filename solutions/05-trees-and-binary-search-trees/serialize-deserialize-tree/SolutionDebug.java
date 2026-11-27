package practice.trees_and_binary_search_trees.serialize_deserialize_tree;

import java.util.*;

/** Serialize and Deserialize Binary Tree. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: serialize(root = [1,2,3])
    //   Output: "1,2,#,#,3,#,#,"
    // Example 2:
    //   Input: deserialize(data = "1,2,#,#,3,#,#,")
    //   Output: root = [1,2,3]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }
    public String serialize(TreeNode root) {
        StringBuilder out = new StringBuilder();
        // RECURSION ENTRY: start out="" and visit root 1.
        write(root, out);
        return out.toString();
    }
    private void write(TreeNode node, StringBuilder out) {
        // WRITE BASE CASE: append "#," for a missing child, then return to its parent.
        if (node == null) { out.append("#,"); return; }
        // After appending real nodes in preorder: "1," then "1,2," then "1,2,#,#,3,".
        out.append(node.val).append(',');
        // RECURSIVE LEFT CALL: fully encode the left subtree before writing the right.
        write(node.left, out);
        // RECURSIVE RIGHT CALL: after both children of 3 return, out="1,2,#,#,3,#,#,".
        write(node.right, out);
    }
    public TreeNode deserialize(String data) {
        return read(Arrays.asList(data.split(",")).iterator());
    }
    private TreeNode read(Iterator<String> tokens) {
        // READ RECURSION: tokens consumed in order 1,2,#,#,3,#,#. Each call consumes its own next token.
        String token = tokens.next();
        // READ BASE CASE: # returns null, marking exactly one missing child.
        if (token.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        // RECURSIVE LEFT CALL: node 1 receives node 2; node 2 receives null.
        node.left = read(tokens);
        // RECURSIVE RIGHT CALL: node 1 receives node 3; leaves receive null.
        node.right = read(tokens);
        // UNWIND: finish node 2, then node 3, then root 1 -> reconstructed tree [1,2,3].
        return node;
    }
}
