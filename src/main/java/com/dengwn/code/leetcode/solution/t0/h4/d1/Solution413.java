package com.dengwn.code.leetcode.solution.t0.h4.d1;

/**
 * @author: dengwn
 * @date: 2023-02-10
 **/
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int ans = 0;
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }

        int pre = 0;
        for (int i = 1; i < n - 1; i++) {
            if (diff[i] == diff[pre]) {
                ans += (i - pre);
            } else {
                pre = i;
            }
        }
        return ans;
    }
}
