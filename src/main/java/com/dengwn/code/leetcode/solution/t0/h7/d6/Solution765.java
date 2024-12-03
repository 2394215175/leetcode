package com.dengwn.code.leetcode.solution.t0.h7.d6;

/**
 * @author: dengwn
 * @date: 2024-03-27
 **/
public class Solution765 {
    int[] p = new int[70];

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n - 1; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (i == find(i)) {
                cnt++;
            }
        }
        return m - cnt;
    }

    public static void main(String[] args) {
        Solution765 solution765 = new Solution765();
        int[] row = {0,2,1,3};
        System.out.println(solution765.minSwapsCouples(row));
    }
}
