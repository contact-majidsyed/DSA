package practice.linked_lists_stacks_and_queues.daily_temperatures;

import java.util.*;

/** Daily Temperatures. See explanation.md for the contract and walkthrough. */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previous = stack.pop();
                answer[previous] = i - previous;
            }
            stack.push(i);
        }
        return answer;
    }
}
