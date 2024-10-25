package com.dengwn.code.leetcode.solution.t2.h5;

/**
 * @author: dengwn
 * @date: 2024-04-09
 **/
public class Solution2529 {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for (int num : nums) {
            if (num < 0) {
                neg++;
            }
            if (num > 0) {
                pos++;
            }
        }
        return Math.max(neg, pos);
    }
}
