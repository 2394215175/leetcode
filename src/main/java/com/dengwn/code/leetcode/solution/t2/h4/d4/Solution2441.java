package com.dengwn.code.leetcode.solution.t2.h4.d4;

/**
 * @author dengwn
 * @date: 2023-05-13
 */
public class Solution2441 {
    public int findMaxK(int[] nums) {
        int[] arr = new int[2001];
        for (int num : nums) {
            arr[num + 1000]++;
        }
        for (int i = 2000; i > 1000; i--) {
            if (arr[i] >= 1 && arr[2000 - i] >= 1) {
                return i - 1000;
            }
        }
        return -1;
    }
}
