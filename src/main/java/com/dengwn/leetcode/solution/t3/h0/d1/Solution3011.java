package com.dengwn.leetcode.solution.t3.h0.d1;

/**
 * @author dengwenning
 * @since 2024/7/14
 **/
public class Solution3011 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n;) {
            int mx = 0;
            int one = Integer.bitCount(nums[i]);
            while (i < n && Integer.bitCount(nums[i]) == one) {
                if (nums[i] < max){
                    return false;
                }
                mx = Math.max(mx, nums[i]);
                i++;
            }
            max = mx;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3011 solution3011 = new Solution3011();
        System.out.println(solution3011.canSortArray(new int[]{2,28,9}));
    }
}
