package com.dengwn.code.leetcode.solution.t0.h7.d0;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
