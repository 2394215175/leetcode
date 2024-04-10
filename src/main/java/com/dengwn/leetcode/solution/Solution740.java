package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-03
 **/
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] res = new int[10001];
        for (int num : nums) {
            res[num] += num;
        }
        int first = 0;
        int second = 0;
        for (int re : res) {
            int temp = second;
            second = Math.max(first + re, second);
            first = temp;
        }
        return second;
    }
}
