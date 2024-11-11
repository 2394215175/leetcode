package com.dengwn.code.leetcode.solution.t0.h5.d4;

/**
 *
 * @author dengwenning
 * @since 2024/11/11
 **/
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length / 2;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * 2 + 1 > nums.length - 1 || nums[mid * 2] != nums[mid * 2 + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left * 2];
    }

    public static void main(String[] args) {
        Solution540 solution540 = new Solution540();
        System.out.println(solution540.singleNonDuplicate(new int[]{1, 1, 2}));
    }
}
