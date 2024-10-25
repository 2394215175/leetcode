package com.dengwn.code.leetcode.solution.t1.h6;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/5/5
 **/
public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = 0; j < k; j++) {
                    ans[i] += code[i + j + 1];
                }
            } else if (k < 0) {
                for (int j = k; j < 0; j++) {
                    ans[i] += code[(j + i + n) % n];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1652 solution1652 = new Solution1652();
        System.out.println(Arrays.toString(solution1652.decrypt(new int[]{2, 4, 9, 3}, -2)));
    }
}
