package practice.backtracking_recursion_and_tries.implement_trie;

import java.util.*;

/** Implement Trie. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: insert("apple"); search("apple"); search("app"); startsWith("app")
    //   Output: query results: [true,false,true]
    // Example 2:
    //   Input: insert("app"); search("app"); startsWith("bat")
    //   Output: query results: [true,false]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public static class Trie {
        private static class Node {
            Node[] children = new Node[26];
            boolean end;
        }
        private final Node root = new Node();
        public void insert(String word) {
            // START insert or walk at root. Each operation starts a fresh traversal reference.
            Node node = root;
            // ===== LOOP START L1: for loop =====
            for (int i = 0; i < word.length(); i++) {
                // INSERT apple: i=0..4 -> index=0,15,15,11,4, for a,p,p,l,e.
                int index = word.charAt(i) - 'a';
                // On the first insert, allocate one missing child per letter; existing prefixes are reused on later inserts.
                if (node.children[index] == null) node.children[index] = new Node();
                // AFTER each insert visit: node represents prefixes a,ap,app,appl,apple.
                node = node.children[index];
            }
            // ===== LOOP END L1 =====
            // AFTER insert loop: mark only apple as complete. app is still just a prefix.
            node.end = true;
        }
        private Node walk(String text) {
            // START insert or walk at root. Each operation starts a fresh traversal reference.
            Node node = root;
            // ===== LOOP START L2: for loop =====
            for (int i = 0; i < text.length(); i++) {
                // WALK VISITS for app: node follows a -> ap -> app. For apple, continue to appl -> apple.
                node = node.children[text.charAt(i) - 'a'];
                // EARLY WALK RETURN: a missing child ends lookup. Example 2 startsWith(bat) fails at b.
                if (node == null) return null;
            }
            // ===== LOOP END L2 =====
            return node;
        }
        public boolean search(String word) {
            Node node = walk(word);
            // search(apple): end=true -> true. search(app) before inserting app: end=false -> false.
            return node != null && node.end;
        }
        // OPERATION RETURN: startsWith(app) checks the path only -> true.
        // Example 2 inserts app first, so search(app) is then true.
        public boolean startsWith(String prefix) { return walk(prefix) != null; }
    }
}
