package com.dengwn.leetcode.doubleWeeklyComp;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-02-27
 **/
public class DoubleWeeklyComp98 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        char a = chars[0];
        char b = chars[0];
        int max = 0;
        int min = 0;
        for (char c : chars) {
            if (c != '9') {
                a = c;
                break;
            }
        }
        for (char c : chars) {
            max = 10 * max + (c == a ? 9 : c - '0');
            min = 10 * min + (c == b ? 0 : c - '0');
        }

        return max - min;
    }


    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.min(nums[n - 1] - nums[2], Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]));
    }

    public static void main(String[] args) {
        DoubleWeeklyComp98 doubleWeeklyComp98 = new DoubleWeeklyComp98();

        System.out.println(doubleWeeklyComp98.minMaxDifference(11891));
    }
}
