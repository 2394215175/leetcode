package com.dengwn.code.leetcode.solution.t2.h9.d7;

/**
 * @author dengwenning
 * @since 2024/7/10
 **/
public class Solution2970 {

    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(nums, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean check(int[] nums, int i, int j) {
        int pre = -1;
        for (int k = 0; k < nums.length; k++) {
            if (k >= i && k <= j) {
                continue;
            }
            if (nums[k] <= pre) {
                return false;
            }
            pre = nums[k];
        }
        return true;
    }
}
