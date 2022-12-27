package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-26
 **/
public class Solution1491 {
    public double average(int[] salary) {
        int length = salary.length;
        Arrays.sort(salary);
        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            sum += salary[i];
        }
        return sum * 1.0 / (length - 2);
    }
}
