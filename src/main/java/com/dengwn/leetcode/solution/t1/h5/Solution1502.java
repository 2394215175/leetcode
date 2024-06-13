package com.dengwn.leetcode.solution.t1.h5;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}
