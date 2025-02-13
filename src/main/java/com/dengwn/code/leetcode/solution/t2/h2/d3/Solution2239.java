package com.dengwn.code.leetcode.solution.t2.h2.d3;

/**
 *
 * @author dengwenning
 * @since 2025/1/20
 **/
public class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans) || (Math.abs(num) == Math.abs(ans) && ans < 0)) {
                ans = num;
            }
        }
        return ans;
    }
}
