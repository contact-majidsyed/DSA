package practice.linked_lists_stacks_and_queues.valid_parentheses;

import java.util.*;

/** Valid Parentheses. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: s = "({[]})"
    //   Output: true
    // Example 2:
    //   Input: s = "([)]"
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean isValid(String s) {
        // START empty. Stack displays below list the TOP first.
        Deque<Character> stack = new ArrayDeque<>();
        // ===== LOOP START L1: for loop =====
        for (char c : s.toCharArray()) {
            // For ({[]}): visits c=(,{,[,],},).
            // After each visit, expected closers top-first are: ")" -> "})" -> "]})" -> "})" -> ")" -> empty.
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            // On a closer, pop exactly one expected closer. A mismatch returns false immediately.
            // Example 2 ([)]: after (,[: top is ]; reading ) pops ] and returns false.
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        // ===== LOOP END L1 =====
        // RETURN true for Example 1: all expected closers were consumed.
        return stack.isEmpty();
    }
}
