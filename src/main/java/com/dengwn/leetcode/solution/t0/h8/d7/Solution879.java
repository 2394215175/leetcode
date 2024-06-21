package com.dengwn.leetcode.solution.t0.h8.d7;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/21
 **/
public class Solution879 {

    int minProfit;
    int[] group;
    int[] profits;
    int[][][] memo;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l = group.length;
        this.minProfit = minProfit;
        this.group = group;
        this.profits = profit;
        this.memo = new int[l][n + 1][minProfit + 1];
        for (int[][] m : memo) {
            for (int[] i : m) {
                Arrays.fill(i, -1);
            }
        }
        return dfs(l - 1, n, 0);
    }

    int MOD = (int) 1e9 + 7;

    // i 下标， c 剩余人数， profit 当前利润
    public int dfs(int i, int c, int profit) {
        if (i < 0) {
            return profit >= minProfit ? 1 : 0;
        }
        if (memo[i][c][profit] != -1) {
            return memo[i][c][profit];
        }
        int ans = 0;
        if (group[i] <= c) {
            // 小于的时候可以选
            // 取最小值防止下标越界
            ans += dfs(i - 1, c - group[i], Math.min(minProfit, profit + profits[i]));
        }
        ans += dfs(i - 1, c, profit);
        return memo[i][c][profit] = ans % MOD;
    }

    public static void main(String[] args) {
        int n = 1;
        int minProfit = 1;
        int[] group = {1, 1, 1, 1, 2, 2, 1, 2, 1, 1};
        int[] profit = {0, 1, 0, 0, 1, 1, 1, 0, 2, 2};
        Solution879 solution879 = new Solution879();
        int res = solution879.profitableSchemes(n, minProfit, group, profit);
        System.out.println(res);
    }
}
