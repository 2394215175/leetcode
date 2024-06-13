package com.dengwn.leetcode.solution.t1.h7;

/**
 * @author dengwn
 * @date: 2022-11-28
 */
public class Solution1752 {
    public boolean check(int[] nums) {
        int length = nums.length;
        int cnt = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt == 0 || (cnt == 1 && nums[0] > nums[length - 1]);
    }
}
