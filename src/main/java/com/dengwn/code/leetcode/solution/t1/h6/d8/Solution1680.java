package com.dengwn.code.leetcode.solution.t1.h6.d8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/11/14
 **/
public class Solution1680 {

    int min = Integer.MAX_VALUE;
    List<int[]>[] graph;

    public int minScore(int n, int[][] roads) {
        graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited);
        return min;
    }

    public void dfs(int cur, boolean[] vis) {
        if (vis[cur]){
            return;
        }
        vis[cur] = true;
        for (int[] next : graph[cur]) {
            int v = next[0];
            int w = next[1];
            min = Math.min(min, w);
            dfs(v, vis);
        }
    }
}
