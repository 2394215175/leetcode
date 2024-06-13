package com.dengwn.leetcode.solution.t0.h1;

/**
 * @author: dengwn
 * @date: 2023-01-12
 **/
public class Solution152 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);

            ans = Math.max(ans, max);
        }
        return ans;


    }
}
