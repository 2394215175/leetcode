package com.dengwn.code.leetcode.solution.t0.h9.d1;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/21
 **/
public class Solution910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // 最小值是num[0] + k, num[i + 1] - k
        // 最大值是num[i] + k, num[n - 1] - k;
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[i] + k, nums[n - 1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution910 solution910 = new Solution910();
        int[] nums = {2,7,2};
        int k = 1;
        System.out.println(solution910.smallestRangeII(nums, k));

    }
}
