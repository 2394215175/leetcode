package com.dengwn.code.leetcode.solution.t2.h9;

/**
 * @author dengwenning
 * @since 2024/5/25
 **/
public class Solution2903 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i >= indexDifference && Math.abs(nums[j] - nums[i]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
