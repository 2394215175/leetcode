package com.dengwn.leetcode.weeklyComp.h3.d9;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/4
 **/
public class WeeklyComp394 {

    public int numberOfSpecialChars(String word) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a') {
                cnt2[c - 'a']++;
            } else {
                cnt1[c - 'A']++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0 && cnt2[i] > 0) {
                ans++;
            }
        }
        return ans;
    }

    public int numberOfSpecialChars1(String word) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        Arrays.fill(cnt1, -1);
        Arrays.fill(cnt2, -1);
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c >= 'a') {
                cnt2[c - 'a'] = i;
            } else {
                if (cnt1[c - 'A'] < 0) {
                    cnt1[c - 'A'] = i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] >= 0 && cnt2[i] >= 0 && cnt2[i] < cnt1[i]) {
                ans++;
            }
        }
        return ans;
    }

    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] cnt = new int[m][10];
        for (int i = 0; i < m; i++) {
            for (int[] ints : grid) {
                cnt[i][ints[i]]++;
            }
        }
        int[][] dp = new int[m][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = n - cnt[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 10; j++) {
                int min = Integer.MAX_VALUE;
                // 从前一个地方转移过来
                for (int k = 0; k < 10; k++) {
                    if (j != k) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = n - cnt[i][j] + min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            g[edge[0]].add(new int[]{edge[1], edge[2], i});
            g[edge[1]].add(new int[]{edge[0], edge[2], i});
        }

        // 从0开始求最段路
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingLong(a -> dis[a]));
        queue.add(0);
        dis[0] = 0;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = k; i > 0; i--) {
                int u = queue.poll();
                for (int[] t : g[u]) {
                    int v = t[0];
                    int w = t[1];
                    if (dis[u] + w < dis[v]) {
                        dis[v] = dis[u] + w;
                        queue.offer(v);
                    }
                }
            }
        }
        // 从n-1开始算边
        queue.add(n - 1);
        boolean[] ans = new boolean[m];
        boolean[] vis = new boolean[n];
        vis[n - 1] = true;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = k; i > 0; i--) {
                int u = queue.poll();
                for (int[] t : g[u]) {
                    int v = t[0];
                    int w = t[1];
                    int b = t[2];
                    if (dis[u] - w != dis[v]) {
                        continue;
                    }
                    ans[b] = true;
                    if (!vis[v]) {
                        vis[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp394 weeklyComp394 = new WeeklyComp394();

//        int[][] grid = {
//                {0, 6, 2},
//                {9, 0, 9},
//                {4, 9, 6}};
//        System.out.println(weeklyComp394.minimumOperations(grid));


        int n = 4;
        int[][] edges = {{2, 0, 1}, {0, 1, 1}, {0, 3, 4}, {3, 2, 2}};

        System.out.println(Arrays.toString(weeklyComp394.findAnswer(n, edges)));


    }
}
