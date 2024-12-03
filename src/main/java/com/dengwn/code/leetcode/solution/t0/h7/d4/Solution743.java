package com.dengwn.code.leetcode.solution.t0.h7.d4;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/11/25
 **/
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
        queue.offer(k);
        dist[k] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : graph[cur]) {
                int v = next[0];
                if (dist[cur] + next[1] < dist[v]) {
                    dist[v] = dist[cur] + next[1];
                    queue.offer(v);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
