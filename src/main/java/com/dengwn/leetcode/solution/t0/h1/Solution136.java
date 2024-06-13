package com.dengwn.leetcode.solution.t0.h1;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution136 {
    public int singleNumber(int[] nums) {
        int[] res = new int[60000];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i] + 30000]++;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                return i - 30000;
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
