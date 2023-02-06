package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-30
 **/
public class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int last = n - 1;
        int left = 0;
        int right = last;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                return Math.min(nums[mid], nums[mid + 1]);
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[last] > nums[mid] && nums[mid] > nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    public int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        Solution153 solution153 = new Solution153();
        int[] nums = {5, 1, 2, 3, 4};
        System.out.println(solution153.findMin(nums));
    }
}
