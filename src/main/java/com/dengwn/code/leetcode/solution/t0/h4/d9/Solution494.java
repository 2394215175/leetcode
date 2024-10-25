package com.dengwn.code.leetcode.solution.t0.h4.d9;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/30
 **/
public class Solution494 {
    int[] nums;
    int target;
    int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        memo = new int[n][2001];
        for (int[] arr : memo) {
            Arrays.fill(arr, -10000);
        }
        return dfs(n - 1, 0);
    }

    public int dfs(int i, int j) {
        if (i < 0) {
            return j == target ? 1 : 0;
        }
        int k = 1000 + j;
        if (memo[i][k] != -10000) {
            return memo[i][k];
        }
        int res1 = dfs(i - 1, j + nums[i]);
        int res2 = dfs(i - 1, j - nums[i]);
        return memo[i][k] = res1 + res2;
    }
}
