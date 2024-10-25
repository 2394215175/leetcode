package com.dengwn.code.leetcode.solution.t0.h8.d9;

/**
 * @author: dengwn
 * @date: 2023-02-23
 **/
public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        boolean isLow = false;
        boolean isHigh = false;
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] == pre){
                continue;
            }
            if (isHigh && pre > nums[i]) {
                return false;
            }
            if (isLow && pre < nums[i]) {
                return false;
            }
            isLow = pre > nums[i];
            isHigh = pre < nums[i];
            pre = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution896 solution896 = new Solution896();
        int[] nums = {11, 11, 9, 4, 3, 3, 3, 1, -1, -1, 3, 3, 3, 5, 5, 5};
        System.out.println(solution896.isMonotonic(nums));
    }
}
