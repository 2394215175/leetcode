package com.dengwn.code.leetcode.solution.t3.h0.d4;

/**
 *
 * @author dengwenning
 * @since 2025/1/7
 **/
public class Solution3046 {
    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > 2) {
                return false;
            }
        }
        return true;
    }
}
