package practice.linked_lists_stacks_and_queues.daily_temperatures;

import java.util.*;

/** Daily Temperatures. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: temperatures = [73,74,75,71,69,72,76]
    //   Output: [1,1,4,2,1,1,0]
    // Example 2:
    //   Input: temperatures = [30,30]
    //   Output: [0,0]
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // START answer=[0,0,0,0,0,0,0], stack empty. Stack stores unresolved indices, top first.
        Deque<Integer> stack = new ArrayDeque<>();
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < temperatures.length; i++) {
            // ===== LOOP START L2: while loop =====
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pops by i: 0:none; 1:[0]; 2:[1]; 3:none; 4:none; 5:[4,3]; 6:[5,2].
                int previous = stack.pop();
                // Resolved entries: i=1 -> answer[0]=1; i=2 -> answer[1]=1;
                // i=5 -> answer[4]=1,answer[3]=2; i=6 -> answer[5]=1,answer[2]=4.
                answer[previous] = i - previous;
            }
            // ===== LOOP END L2 =====
            // AFTER each outer visit, stack top-first:
            // i=0:[0]; 1:[1]; 2:[2]; 3:[3,2]; 4:[4,3,2]; 5:[5,2]; 6:[6].
            stack.push(i);
        }
        // ===== LOOP END L1 =====
        // RETURN [1,1,4,2,1,1,0]. Index 6 never finds a warmer day, so its answer stays zero.
        return answer;
    }
}
