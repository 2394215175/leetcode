package com.dengwn.leetcode.solution.t0.h0.d3;

/**
 * @author: dengwn
 * @date: 2023-01-29
 **/
public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧有序
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧有序
                if (nums[mid] < target && nums[n] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution33.search(nums, 0));
    }
}
