package com.dengwn.leetcode.solution.t1.h0;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-05-27
 */
public class Solution1093 {
    public double[] sampleStats(int[] count) {
        int n = count.length;
        double sum = 0.0;
        int cnt = 0;
        double minimum = 0.0;
        double maximum = 0.0;
        double median = 0.0;
        double mode = 0.0;
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                maximum = i;
                cnt += count[i];
                sum += i * count[i];
                if (count[i] > maxSize) {
                    maxSize = count[i];
                    mode = i;
                }
            }
        }
        int left = 0;
        int right = cnt;
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] > 0) {
                minimum = i;
                if (right > cnt / 2){

                }
            }
        }

        return new double[]{minimum, maximum, sum / cnt, median, mode};
    }

    public static void main(String[] args) {
        Solution1093 solution1093 = new Solution1093();
        int[] count = {0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(Arrays.toString(solution1093.sampleStats(count)));
    }
}
