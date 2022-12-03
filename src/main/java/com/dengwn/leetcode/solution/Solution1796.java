package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-12-03
 */
public class Solution1796 {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                }
                if (num < first && num > second) {
                    second = num;
                }

            }
        }
        return second;
    }

    public int secondHighest1(String s) {
        int cnt = 2;
        boolean[] nums = new boolean[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                nums[c - '0'] = true;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (nums[i]) {
                cnt--;
            }
            if (cnt == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final Solution1796 solution1796 = new Solution1796();
        System.out.println(solution1796.secondHighest("abc1111"));
    }
}
