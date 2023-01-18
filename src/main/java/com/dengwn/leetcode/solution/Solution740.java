package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-03
 **/
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] res = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]] += nums[i];
        }
        int first = 0;
        int second = 0;
        for (int i = 0; i < res.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
