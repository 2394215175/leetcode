package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/10/28
 **/
public class DoubleWeeklyComp142 {

    public int possibleStringCount(String word) {
        int ans = 1;
        char prev = word.charAt(0);
        char[] array = word.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == prev) {
                ans++;
            }
            prev = array[i];
        }
        return ans;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        return new int[0];
    }

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] f = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i - 1][j] + stayScore[i - 1][j];
                for (int jj = 0; jj < n; jj++) {
                    if (j != jj){
                        f[i][j] = Math.max(f[i][j], f[i - 1][jj] + travelScore[jj][j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f[k][i]);
        }
        return ans;
    }

    public int possibleStringCount(String word, int k) {
        int ans = 1;
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp142 doubleWeeklyComp142 = new DoubleWeeklyComp142();

        System.out.println(doubleWeeklyComp142.possibleStringCount("ere"));
    }
}
