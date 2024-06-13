package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/12
 **/
public class Solution3040 {
    private int[][] memo;

    public int maxOperations(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int res1 = dfs(nums, 2, n - 1, nums[0] + nums[1]);
        int res2 = dfs(nums, 1, n - 2, nums[0] + nums[n - 1]);
        int res3 = dfs(nums, 0, n - 3, nums[n - 1] + nums[n - 2]);
        return Math.max(res1, Math.max(res2, res3)) + 1;
    }

    public int dfs(int[] nums, int l, int r, int target) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int cnt = 0;
        if (nums[l] + nums[l + 1] == target) {
            cnt = Math.max(cnt, dfs(nums, l + 2, r, target));
        }
        if (nums[r] + nums[r - 1] == target) {
            cnt = Math.max(cnt, dfs(nums, l, r - 2, target));
        }
        if (nums[l] + nums[r] == target) {
            cnt = Math.max(cnt, dfs(nums, l + 1, r - 1, target));
        }
        return memo[l][r] = cnt;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4};
        Solution3040 solution3040 = new Solution3040();
        System.out.println(solution3040.maxOperations(nums));
    }
}
