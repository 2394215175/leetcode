package com.dengwn.leetcode.solution.t2.h7.d4;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/7/26
 **/
public class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }
        return ans;
    }
}
