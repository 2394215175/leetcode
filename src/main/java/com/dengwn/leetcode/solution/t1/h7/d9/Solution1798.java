package com.dengwn.leetcode.solution.t1.h7.d9;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-02-06
 **/
public class Solution1798 {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution1798 solution1798 = new Solution1798();
        int[] nums = {1, 4, 10, 3, 1};
        System.out.println(solution1798.getMaximumConsecutive(nums));
    }
}
