package com.dengwn.code.leetcode.solution.t2.h2.d7;

/**
 *
 * @author dengwenning
 * @since 2025/1/13
 **/
public class Solution2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        long sum = 0;
        long pre = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n - 1; i++) {
            pre += nums[i];
            if (pre * 2 >= sum) {
                ans++;
            }
        }
        return ans;
    }
}
