package com.dengwn.leetcode.solution.t1.h7.d4;

/**
 * @author: dengwn
 * @date: 2024-04-03
 **/
public class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int s = 0;
        int max = 0;
        int min = 0;
        for (int num : nums) {
            s += num;
            if (max < s) {
                max = s;
            }
            if (min > s) {
                min = s;
            }
        }
        return max - min;
    }

    public int maxAbsoluteSum1(int[] nums) {
        int max = 0;
        int min = 0;
        int ans = 0;
        for (int num : nums) {
            max = Math.max(num, max + num);
            min = Math.min(num, min + num);
            ans = Math.max(ans, Math.max(max, -min));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1749 solution1749 = new Solution1749();
        System.out.println(solution1749.maxAbsoluteSum1(new int[]{1,-3,2,3,-4}));
    }
}
