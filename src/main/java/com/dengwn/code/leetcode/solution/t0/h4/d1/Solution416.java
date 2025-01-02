package com.dengwn.code.leetcode.solution.t0.h4.d1;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/11
 **/
public class Solution416 {

    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[nums.length][sum / 2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums, 0, 0, sum / 2);
    }

    public boolean dfs(int[] nums, int i, int cur, int target) {
        if (cur == target) {
            return true;
        }
        if (cur > target || i >= nums.length) {
            return false;
        }
        if (memo[i][cur] != -1) {
            return memo[i][cur] == 1;
        }
        // 选 or 不选
        boolean res = dfs(nums, i + 1, cur + nums[i], target) || dfs(nums, i + 1, cur, target);
        memo[i][cur] = res ? 1 : 0;
        return res;
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= 0; j--) {
                f[j] = f[j] || (j >= num && f[j - num]);
            }
        }
        return f[sum];
    }

    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.canPartition1(new int[]{1, 2, 5}));
    }
}
