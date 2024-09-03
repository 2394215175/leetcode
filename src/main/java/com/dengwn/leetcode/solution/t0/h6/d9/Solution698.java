package com.dengwn.leetcode.solution.t0.h6.d9;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/8/27
 **/
public class Solution698 {

    int target;
    int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        this.k = k;
        this.target = sum / k;
        if (Arrays.stream(nums).anyMatch(i -> i > target)) {
            return false;
        }
        return dfs(nums, target, 0, new boolean[n], 0);
    }

    public boolean dfs(int[] nums, int target, int pre, boolean[] visited, int cnt) {
        if (cnt == k) {
            return true;
        }
        if (pre > target) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            pre += nums[i];
            if (pre == target) {
                cnt++;
                pre = 0;
            }
            visited[i] = true;
            if (dfs(nums, target, pre, visited, cnt)) {
                return true;
            }
            pre -= nums[i];
            visited[i] = false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution698 solution698 = new Solution698();
        int[] nums = {2, 2, 2, 2, 3, 4, 5};
        System.out.println(solution698.canPartitionKSubsets(nums, 4));
    }
}
