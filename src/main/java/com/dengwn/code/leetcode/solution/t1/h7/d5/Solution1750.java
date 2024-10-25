package com.dengwn.code.leetcode.solution.t1.h7.d5;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution1750 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char cur = s.charAt(left);
            while (left <= right && s.charAt(left) == cur) {
                left++;
            }
            while (left <= right && s.charAt(right) == cur) {
                right--;
            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        Solution1750 solution1750 = new Solution1750();
        System.out.println(solution1750.minimumLength("bccccb"));
    }
}
