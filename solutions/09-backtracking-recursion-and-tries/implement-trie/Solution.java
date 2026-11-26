package practice.backtracking_recursion_and_tries.implement_trie;

import java.util.*;

/** Implement Trie. See explanation.md for the contract and walkthrough. */
public class Solution {
    public static class Trie {
        private static class Node {
            Node[] children = new Node[26];
            boolean end;
        }
        private final Node root = new Node();
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) node.children[index] = new Node();
                node = node.children[index];
            }
            node.end = true;
        }
        private Node walk(String text) {
            Node node = root;
            for (int i = 0; i < text.length(); i++) {
                node = node.children[text.charAt(i) - 'a'];
                if (node == null) return null;
            }
            return node;
        }
        public boolean search(String word) {
            Node node = walk(word);
            return node != null && node.end;
        }
        public boolean startsWith(String prefix) { return walk(prefix) != null; }
    }
}
