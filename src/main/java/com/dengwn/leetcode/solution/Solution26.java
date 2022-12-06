package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > pre){
                pre = nums[i];
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution26.removeDuplicates(nums));
    }
}
