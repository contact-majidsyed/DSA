package practice.graphs_and_union_find.course_schedule;

import java.util.*;

/** Course Schedule. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: n = 3, prerequisites = [[1,0],[2,1]]
    //   Output: true
    // Example 2:
    //   Input: n = 2, prerequisites = [[1,0],[0,1]]
    //   Output: false
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        // INITIALIZATION VISITS i=0,1,2: create three empty neighbor lists.
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        // ===== LOOP END L1 =====
        int[] indegree = new int[n];
        // ===== LOOP START L2: for loop =====
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            // BUILD VISITS [1,0], [2,1]: graph becomes 0->[1],1->[2],2->[].
            // indegree changes [0,0,0] -> [0,1,0] -> [0,1,1].
            indegree[pair[0]]++;
        }
        // ===== LOOP END L2 =====
        Queue<Integer> queue = new ArrayDeque<>();
        // SEED VISITS i=0,1,2: only course 0 has indegree zero -> queue=[0].
        // ===== LOOP START L3: for loop =====
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);
        // ===== LOOP END L3 =====
        int completed = 0;
        // ===== LOOP START L4: while loop =====
        while (!queue.isEmpty()) {
            int course = queue.remove();
            // PROCESS VISITS: course=0,1,2 -> completed=1,2,3.
            completed++;
            // After course 0: indegree[1]=0 -> enqueue 1. After course 1: indegree[2]=0 -> enqueue 2.
            // Course 2 has no neighbors; queue becomes empty.
            // ===== LOOP START L5: for loop =====
            for (int next : graph.get(course)) if (--indegree[next] == 0) queue.add(next);
            // ===== LOOP END L5 =====
        }
        // ===== LOOP END L4 =====
        // RETURN 3==3 -> true. Example 2 is a cycle: initial queue empty, completed=0 -> false.
        return completed == n;
    }
}
