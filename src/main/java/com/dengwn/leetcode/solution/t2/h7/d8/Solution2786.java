package com.dengwn.leetcode.solution.t2.h7.d8;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/14
 **/
public class Solution2786 {
    long[][] memo;

    public long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] & 1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = nums[i] & 1;
            long a = dp[parity] + nums[i];
            long b = dp[parity ^ 1] - x + nums[i];
            long cur = Math.max(a, b);
            if (cur > res){
                res = cur;
            }
            if (cur > dp[parity]){
                dp[parity] = cur;
            }
        }
        return res;
    }

    private long dfs(int i, int j, int[] nums, int x, long[][] memo) {
        if (i == nums.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (nums[i] % 2 != j) {
            return memo[i][j] = dfs(i + 1, j, nums, x, memo);
        }
        long res1 = dfs(i + 1, j, nums, x, memo);
        long res2 = dfs(i + 1, j ^ 1, nums, x, memo);
        return memo[i][j] = Math.max(res1, res2 - x) + nums[i];
    }

    public static void main(String[] args) {
        Solution2786 s = new Solution2786();
        int[] nums = {2, 3, 6, 1, 9, 2};
        System.out.println(s.maxScore(nums, 5));
    }
}
