package com.dengwn.code.leetcode.solution.t2.h0.d6;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/7/1
 **/
public class Solution2065 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            g[u].add(new int[]{v, time});
            g[v].add(new int[]{u, time});
        }

        // 先一遍找出最短路
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dis[o]));
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] edge : g[u]) {
                int v = edge[0];
                int time = edge[1];
                if (dis[u] + time < dis[v]) {
                    dis[v] = dis[u] + time;
                    queue.add(v);
                }
            }
        }

        // 暴力搜索
        this.values = values;
        this.dis = dis;
        this.maxTime = maxTime;
        int[] visited = new int[n];
        visited[0] = 1;
        dfs(0, 0, values[0], g, visited);

        return ans;
    }

    int ans = 0;
    int[] values;
    int[] dis;
    int maxTime;

    public void dfs(int cur, int cutTime, int curVal, List<int[]>[] g, int[] visited) {
        if (cutTime + dis[cur] <= maxTime) {
            // 能回去
            ans = Math.max(ans, curVal);
        } else {
            // 不能回错误答案，下面页没必要走了
            return;
        }
        for (int[] edge : g[cur]) {
            int v = edge[0];
            int time = edge[1];
            int nxVal = curVal + (visited[v] > 0 ? 0 : values[v]);
            int nxTime = cutTime + time;
            visited[v]++;
            dfs(v, nxTime, nxVal, g, visited);
            visited[v]--;
        }
    }


    public static void main(String[] args) {
        Solution2065 solution2065 = new Solution2065();
        int[] values = {0, 32, 10, 43};
        int[][] edges = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime = 49;
        System.out.println(solution2065.maximalPathQuality1(values, edges, maxTime));
        System.out.println((int)Math.pow(4 ,11));
    }

    public int maximalPathQuality1(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int t = e[2];
            g[x].add(new int[]{y, t});
            g[y].add(new int[]{x, t});
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;
        return dfs(0, 0, values[0], vis, g, values, maxTime);
    }

    private int dfs(int x, int sumTime, int sumValue, boolean[] vis, List<int[]>[] g, int[] values, int maxTime) {
        int res = x == 0 ? sumValue : 0;
        for (int[] e : g[x]) {
            int y = e[0];
            int t = e[1];
            if (sumTime + t > maxTime) {
                continue;
            }
            if (vis[y]) {
                res = Math.max(res, dfs(y, sumTime + t, sumValue, vis, g, values, maxTime));
            } else {
                vis[y] = true;
                // 每个节点的价值至多算入价值总和中一次
                res = Math.max(res, dfs(y, sumTime + t, sumValue + values[y], vis, g, values, maxTime));
                vis[y] = false;
            }
        }
        return res;
    }
}
