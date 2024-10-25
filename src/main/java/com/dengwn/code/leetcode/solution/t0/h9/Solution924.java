package com.dengwn.code.leetcode.solution.t0.h9;

/**
 * @author: dengwn
 * @date: 2024-04-16
 **/
public class Solution924 {

    int[] f;

    int find(int x) {
        if (f[x] != x) {
            f[x] = find(f[x]);
        }

        return f[x];
    }

    void merge(int x, int y) {
        f[find(x)] = find(y);
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int m = graph[0].length;
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                if (graph[i][j] == 1) {
                    merge(i, j);
                }
            }
        }
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[find(i)]++;
        }
        int[] cnt = new int[n];
        for (int i : initial) {
            cnt[find(i)]++;
        }
        int ans = initial[0];
        int diff = 0;
        for (int i : initial) {
            int d = cnt[find(i)] == 1 ? table[find(i)] : 0;
            if (d > diff || (d == diff && i < ans)) {
                ans = i;
                diff = table[find(i)];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution924 solution924 = new Solution924();

        int[][] graph = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        int[] initial = {0, 1};
        System.out.println(solution924.minMalwareSpread(graph, initial));
    }
}
