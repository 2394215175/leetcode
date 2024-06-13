package com.dengwn.leetcode.solution.t0.h0.d3;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] nums = {1, 3, 5, 6, 7};
        System.out.println(solution35.searchInsert(nums, 2));
        int i = Arrays.binarySearch(nums, 3);
        System.out.println(i);
    }
}
