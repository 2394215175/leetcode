package com.dengwn.leetcode.solution.t1.h9;

/**
 * @author dengwn
 * @date: 2022-12-19
 */
public class Solution1971 {
    int[] pre;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    public int find(int x) {
        while (pre[x] != x) {
            x = pre[x];
        }
        return x;
    }

    public void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            pre[fx] = fy;
        }
    }

    public static void main(String[] args) {
        Solution1971 solution1971 = new Solution1971();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;
        System.out.println(solution1971.validPath(n, edges, source, destination));
    }
}
