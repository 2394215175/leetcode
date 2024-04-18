package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2024-04-17
 **/
public class Solution928 {

    public static void main(String[] args) {
        Solution928 solution928 = new Solution928();
        int[][] graph = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        int[] initial = {0, 1};
        System.out.println(solution928.minMalwareSpread(graph, initial));
    }

    int[] f;
    int[] size;

    int find(int x) {
        if (f[x] != x) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) {
            return;
        }
        if (size[fx] > size[fy]) {
            f[fy] = fx;
            size[fx] += size[fy];
        } else {
            f[fx] = fy;
            size[fy] += size[fx];
        }
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        f = new int[n];
        size = new int[n];
        boolean[] isInitial = new boolean[n];
        for (int i : initial) {
            isInitial[i] = true;
        }
        for (int i = 0; i < n; i++) {
            f[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1 && !isInitial[i] && !isInitial[j]) {
                    union(i, j);
                }
            }
        }

        Set<Integer>[] g = new Set[n];
        Arrays.setAll(g, k -> new HashSet<>());
        int[] cnt = new int[n];
        for (int i : initial) {
            for (int j = 0; j < n; j++) {
                if (!isInitial[j] && graph[i][j] == 1) {
                    g[i].add(find(j));
                }
            }
            for (int root : g[i]) {
                cnt[root]++;
            }
        }

        int ans = 0, mx = -1;
        for (int i : initial) {
            int t = 0;
            for (int root : g[i]) {
                if (cnt[root] == 1) {
                    t += size[root];
                }
            }
            if (t > mx || (t == mx && i < ans)) {
                ans = i;
                mx = t;
            }
        }
        return ans;
    }
}
