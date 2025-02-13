package com.dengwn.code.leetcode.solution.t2.h2.d1;

import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2025/1/21
 **/
public class Solution2218 {

    int[][] memo;
    List<List<Integer>> piles;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        memo = new int[n][k + 1];
        this.piles = piles;
        return dfs(n - 1, k);
    }

    public int dfs(int i, int j) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = dfs(i - 1, j);
        int v = 0;
        for (int k = 0; k < Math.min(piles.get(i).size(), j); k++) {
            v += piles.get(i).get(k);
            res = Math.max(res, dfs(i - 1, j - k - 1) + v);
        }
        memo[i][j] = res;
        return res;
    }
}
