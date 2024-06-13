package com.dengwn.leetcode.solution.t0.h0.d6;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] ans = new int[length + 1];
        boolean isOverTen = true;
        for (int i = length - 1; i >= 0; i--) {
            if (isOverTen) {
                int add = digits[i] + 1;
                ans[i + 1] = add % 10;
                isOverTen = add >= 10;
            }else {
                ans[i + 1] = digits[i];
            }
        }

        if(isOverTen){
            ans[0] = 1;
            return ans;
        }else {
            return Arrays.copyOfRange(ans, 1, length + 1);
        }
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] nums = {1, 9, 9};
        int[] ints = solution66.plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
