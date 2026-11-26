package practice.graphs_and_union_find.network_delay_time;

import java.util.*;

/** Network Delay Time. See explanation.md for the contract and walkthrough. */
public class Solution {
    public long networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] edge : times) graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        heap.add(new long[]{0, k});
        while (!heap.isEmpty()) {
            long[] state = heap.remove();
            long d = state[0];
            int node = (int) state[1];
            if (d != distance[node]) continue;
            for (int[] edge : graph.get(node)) {
                long next = d + edge[1];
                if (next < distance[edge[0]]) {
                    distance[edge[0]] = next;
                    heap.add(new long[]{next, edge[0]});
                }
            }
        }
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Long.MAX_VALUE) return -1;
            answer = Math.max(answer, distance[i]);
        }
        return answer;
    }
}
