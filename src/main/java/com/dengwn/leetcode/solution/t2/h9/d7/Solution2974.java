package com.dengwn.leetcode.solution.t2.h9.d7;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/7/12
 **/
public class Solution2974 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }
}
