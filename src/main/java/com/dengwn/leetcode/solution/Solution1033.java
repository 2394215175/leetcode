package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            int temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }

        int diff1 = b - a;
        int diff2 = c - b;
        if (diff1 == 1 && diff2 == 1) {
            return new int[]{0, 0};
        }
        if (diff1 <= 2 || diff2 <= 2) {
            return new int[]{1, diff2 + diff1 - 2};
        }

        return new int[]{2, diff2 + diff1 - 2};
    }


}
