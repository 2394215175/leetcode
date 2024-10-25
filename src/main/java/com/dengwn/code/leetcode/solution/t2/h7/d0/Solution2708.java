package com.dengwn.code.leetcode.solution.t2.h7.d0;

/**
 *
 * @author dengwenning
 * @since 2024/9/3
 **/
public class Solution2708 {
    public long maxStrength(int[] nums) {
        long mm = nums[0];
        long mn = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            long tmp = mn;
            mn = Math.min(Math.min(mn, x), Math.min(mm * x, mn * x));
            mm = Math.max(Math.max(mm, x), Math.max(tmp * x, mm * x));
        }
        return mm;
    }

}
