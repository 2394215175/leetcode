package com.dengwn.code.leetcode.solution.t2.h7.d7;

import java.util.Arrays;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/6/15
 **/
public class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] <= 2 * k) {
                right++;
                res = Math.max(res, right - left);
            } else {
                left++;
            }
        }
        return res;
    }
}
