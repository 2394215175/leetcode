package com.dengwn.leetcode.solution.t1.h8;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-01-05
 **/
public class Solution1803 {
    public int countPairs(int[] nums, int low, int high) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[i] ^ nums[j];
                if (num <= high && num >= low){
                    ans++;
                }
            }
        }
        return ans;
    }
}
