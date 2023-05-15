package com.dengwn.leetcode.solution;

import java.util.HashMap;

/**
 * @author dengwn
 * @date: 2023-05-07
 */
public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        long first = 0;
        long second = 0;
        long[] map = new long[60];
        for (int j : time) {
            map[j % 60]++;
        }
        for (int i = 0; i < 60; i++) {
            if (i == 0 || i == 30) {
                first += map[i] * (map[i] - 1) / 2;
            } else {
                second += map[i] * map[60 - i];
            }
        }
        return (int) (first + second / 2);
    }

    public static void main(String[] args) {

    }
}
