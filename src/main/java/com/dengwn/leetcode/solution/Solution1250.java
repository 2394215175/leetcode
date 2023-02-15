package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-15
 **/
public class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                return true;
            }
        }
        return false;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution1250 solution1250 = new Solution1250();
        int[] nums = {1};
        System.out.println(solution1250.isGoodArray(nums));
    }
}
