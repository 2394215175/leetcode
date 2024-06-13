package com.dengwn.leetcode.solution.t0.h0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-01-29
 **/
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution34.searchRange(nums, 8)));
    }


}
