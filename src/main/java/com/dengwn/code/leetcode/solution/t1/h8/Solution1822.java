package com.dengwn.code.leetcode.solution.t1.h8;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution1822 {
    public int arraySign(int[] nums) {
        int n = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                n++;
            }
        }
        return n % 2 == 1 ? -1 : 1;
    }
}
