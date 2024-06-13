package com.dengwn.leetcode.doubleWeeklyComp.h1.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dengwenning
 * @since 2024/6/7
 **/
public class DoubleWeeklyComp125 {

    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }
        return ans;
    }

    public int minOperations1(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int ans = 0;
        for (int num : nums) {
            queue.add((long) num);
        }
        while (queue.peek() < k && queue.size() >= 2) {
            long x = queue.poll();
            long y = queue.poll();
            long nx = x * 2 + y;
            queue.add(nx);
            ans++;
        }
        return ans;
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int[] next : g[i]) {
                int nv = next[0];
                int nw = next[1];
                int cnt = dfs(g, i, nv, nw, signalSpeed);
                ans[i] += num * cnt;
                num += cnt;
            }
        }
        return ans;
    }

    public int dfs(List<int[]>[] g, int pre, int x, int dis, int signalSpeed) {
        int cnt = dis % signalSpeed == 0 ? 1 : 0;
        for (int[] next : g[x]) {
            int nv = next[0];
            int ns = next[1];
            if (nv != pre) {
                cnt += dfs(g, x, nv, dis + ns, signalSpeed);
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp125 doubleWeeklyComp125 = new DoubleWeeklyComp125();

        int[][] edges = {{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}};
        System.out.println(Arrays.toString(doubleWeeklyComp125.countPairsOfConnectableServers(edges, 1)));

    }
}
