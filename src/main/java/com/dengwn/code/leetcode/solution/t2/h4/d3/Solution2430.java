package com.dengwn.code.leetcode.solution.t2.h4.d3;

/**
 * @author dengwenning
 * @since 2024/6/17
 **/
public class Solution2430 {
    public int deleteString(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (array[i] == array[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; i + j * 2 <= n; j++) {
                if (lcp[i][i + j] >= j) {
                    f[i] = Math.max(f[i], f[i + j]);
                }
            }
            f[i]++;
        }
        return f[0];
    }

    public static void main(String[] args) {
        Solution2430 solution2430 = new Solution2430();
        System.out.println(solution2430.deleteString("aaabaab"));
    }
}
