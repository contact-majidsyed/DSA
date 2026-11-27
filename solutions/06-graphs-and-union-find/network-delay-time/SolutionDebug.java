package practice.graphs_and_union_find.network_delay_time;

import java.util.*;

/** Network Delay Time. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: times = [[1,2,2],[1,3,5],[2,3,1]], n = 3, k = 1
    //   Output: 3
    // Example 2:
    //   Input: times = [[1,2,1]], n = 3, k = 1
    //   Output: -1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public long networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        // INITIALIZE four adjacency slots for n=3; slot 0 is unused.
        // ===== LOOP START L1: for loop =====
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        // ===== LOOP END L1 =====
        // BUILD three edges: 1->2 weight2, 1->3 weight5, 2->3 weight1.
        // ===== LOOP START L2: for loop =====
        for (int[] edge : times) graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        // ===== LOOP END L2 =====
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        // AFTER assignment, distances for vertices 1..3 are [0,INF,INF]. INF means Long.MAX_VALUE.
        distance[k] = 0;
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        heap.add(new long[]{0, k});
        // ===== LOOP START L3: while loop =====
        while (!heap.isEmpty()) {
            // HEAP POPS (distance,node): (0,1), (2,2), (3,3), (5,3).
            long[] state = heap.remove();
            long d = state[0];
            int node = (int) state[1];
            // At final pop (5,3), stored distance[3]=3; skip this stale entry with continue.
            if (d != distance[node]) continue;
            // ===== LOOP START L4: for loop =====
            for (int[] edge : graph.get(node)) {
                long next = d + edge[1];
                if (next < distance[edge[0]]) {
                    // RELAX VISITS: from node1 set distance[2]=2, distance[3]=5; from node2 improve distance[3]=3.
                    // The heap can contain both (3,3) and the obsolete (5,3).
                    distance[edge[0]] = next;
                    heap.add(new long[]{next, edge[0]});
                }
            }
            // ===== LOOP END L4 =====
        }
        // ===== LOOP END L3 =====
        long answer = 0;
        // ===== LOOP START L5: for loop =====
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Long.MAX_VALUE) return -1;
            // FINAL SCAN i=1,2,3: answer=0,2,3. An INF distance would return -1 immediately.
            answer = Math.max(answer, distance[i]);
        }
        // ===== LOOP END L5 =====
        // RETURN 3; Example 2 returns -1 because vertex 3 is unreachable.
        return answer;
    }
}
