package practice.graphs_and_union_find.course_schedule;

import java.util.*;

/** Course Schedule. See explanation.md for the contract and walkthrough. */
public class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.remove();
            completed++;
            for (int next : graph.get(course)) if (--indegree[next] == 0) queue.add(next);
        }
        return completed == n;
    }
}
