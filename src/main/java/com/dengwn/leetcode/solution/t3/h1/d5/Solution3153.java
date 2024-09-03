package com.dengwn.leetcode.solution.t3.h1.d5;

/**
 *
 * @author dengwenning
 * @since 2024/8/30
 **/
public class Solution3153 {
    public long sumDigitDifferences(int[] nums) {
        // 第i位有多少个j
        int[][] cnt = new int[9][10];
        long res = 0;
        for (int l = 0; l < nums.length; l++) {
            int num = nums[l];
            int i = 0;
            while (i < 9 && num > 0) {
                int mod = num % 10;
                res += l - cnt[i][mod];
                cnt[i][mod]++;
                num /= 10;
                i++;
            }
        }
        return res;
    }
}
