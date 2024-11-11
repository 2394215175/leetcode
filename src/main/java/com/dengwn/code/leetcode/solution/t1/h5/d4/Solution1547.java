package com.dengwn.code.leetcode.solution.t1.h5.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/27
 **/
public class Solution1547 {

    int[][] memo;
    int[] cut;

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cut);
        int m = cuts.length;
        cut = new int[m + 2];
        for (int i = 1; i < m + 1; i++) {
            cut[i] = cuts[i - 1];
        }
        cut[0] = 0;
        cut[m + 1] = n;
        memo = new int[m + 2][m + 2];
        return dfs(0, m + 1);
    }

    public int dfs(int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, dfs(i, k) + dfs(k, j));
        }
        ans += cut[j] - cut[i];
        return memo[i][j] = ans;
    }

    public static void main(String[] args) {
        Solution1547 solution1547 = new Solution1547();
        System.out.println(solution1547.minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
