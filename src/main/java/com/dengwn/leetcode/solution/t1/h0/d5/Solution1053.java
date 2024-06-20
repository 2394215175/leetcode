package com.dengwn.leetcode.solution.t1.h0.d5;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-04-03
 **/
public class Solution1053 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution1053 solution1053 = new Solution1053();
        int[] arr = {3,1,1,3};
        System.out.println(Arrays.toString(solution1053.prevPermOpt1(arr)));
    }
}
