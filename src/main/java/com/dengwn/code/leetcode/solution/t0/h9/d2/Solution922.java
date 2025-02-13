package com.dengwn.code.leetcode.solution.t0.h9.d2;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/2/5
 **/
public class Solution922 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[i] = num;
                i += 2;
            } else {
                ans[j] = num;
                j += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution922 solution922 = new Solution922();
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(solution922.sortArrayByParityII(nums)));
    }
}
