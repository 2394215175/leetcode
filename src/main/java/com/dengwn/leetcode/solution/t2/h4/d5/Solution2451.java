package com.dengwn.leetcode.solution.t2.h4.d5;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-25
 **/
public class Solution2451 {
    public String oddString(String[] words) {
        int n = words.length;
        int m = words[0].length();
        int[][] difference = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                difference[i][j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
        }

        if (Arrays.equals(difference[0], difference[1])) {
            for (int i = 2; i < n; i++) {
                if (!Arrays.equals(difference[0], difference[i])) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(difference[0], difference[2]) ? words[1] : words[0];
    }

    public static void main(String[] args) {
        Solution2451 solution2451 = new Solution2451();
        String[] words = {"adc", "wzy", "abc"};
        System.out.println(solution2451.oddString(words));
    }
}
