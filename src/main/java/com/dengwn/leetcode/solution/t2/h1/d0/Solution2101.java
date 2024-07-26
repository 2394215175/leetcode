package com.dengwn.leetcode.solution.t2.h1.d0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dengwenning
 * @since 2024/7/22
 **/
public class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] bomb1 = bombs[i];
                long x1 = bomb1[0], y1 = bomb1[1], r1 = bomb1[2];
                int[] bomb2 = bombs[j];
                long x2 = bomb2[0], y2 = bomb2[1], r2 = bomb2[2];
                // 判断 2 是否在 1 的爆炸范围内
                long k = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                if (k <= r1 * r1) {
                    graph[i].add(j);
                }
                if (k <= r2 * r2) {
                    graph[j].add(i);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, bfs(n, graph, i));
        }
        return ans;
    }

    public int bfs(int n, List<Integer>[] graph, int start) {
        boolean[] vis = new boolean[n];
        vis[start] = true;
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int nei : graph[cur]) {
                if (!vis[nei]) {
                    queue.offer(nei);
                    vis[nei] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

}
