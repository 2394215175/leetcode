package com.dengwn.code.leetcode.solution.t0.h1.d3;

/**
 *
 * @author dengwenning
 * @since 2024/12/26
 **/
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] =  right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        System.out.println(solution135.candy(new int[]{1, 2, 2}));
    }
}
