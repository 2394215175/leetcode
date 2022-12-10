package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[pre] =nums[i];
                res++;
                pre++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(solution27.removeElement(nums,2));
    }
}