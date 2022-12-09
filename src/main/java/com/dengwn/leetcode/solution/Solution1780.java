package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution1780 {
    int[] nums = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721};

    public boolean checkPowersOfThree(int n) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (n < nums[i]) {
                continue;
            }
            n -= nums[i];
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1780 solution1780 = new Solution1780();
        System.out.println(solution1780.checkPowersOfThree(21));
//        for (int i = 0; i < 17; i++) {
//            System.out.print((int) Math.pow(3, i) + ",");
//        }
    }
}
