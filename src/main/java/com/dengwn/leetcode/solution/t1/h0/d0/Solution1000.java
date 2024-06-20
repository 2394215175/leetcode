package com.dengwn.leetcode.solution.t1.h0.d0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-04-04
 **/
public class Solution1000 {

    private int[][][] memo;
    private int[] s;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) {
            // 无法合并成一堆
            return -1;
        }

        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }
        this.k = k;
        memo = new int[n][n][k + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, n - 1, 1);
    }

    private int dfs(int i, int j, int p) {
        if (memo[i][j][p] != -1) {
            System.out.println(memo[i][j][p]);
            return memo[i][j][p];
        }
        if (p == 1) {
            // 合并成一堆
            return memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + s[j + 1] - s[i];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            // 枚举哪些石头堆合并成第一堆
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }
        return memo[i][j][p] = res;
    }

    public static void main(String[] args) {
        Solution1000 solution1000 = new Solution1000();
        int[] stones = {3, 2, 4, 1};
        int K = 2;
        System.out.println(solution1000.mergeStones(stones, K));
    }
}


