package com.dengwn.code.leetcode.solution.t1.h4.d9;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution1491 {
    public double average(int[] salary) {
//        int length = salary.length;
//        Arrays.sort(salary);
//        int sum = 0;
//        for (int i = 1; i < length - 1; i++) {
//            sum += salary[i];
//        }
//        return sum * 1.0 / (length - 2);

        int n = salary.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int j : salary) {
            sum += j;
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
        return 1.0 * (sum - max - min) / (n - 2);
    }
}
