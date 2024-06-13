package com.dengwn.leetcode.solution.t1.h5;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int start = (n + 1) / 2;
        int ans = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            int cur = i == n - 1 - i ? arr[i] : arr[i] + arr[n - 1 - i];
            ans += cur * start;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 14, 5, 3, 8, 7, 12, 13, 1};
        Solution1588 solution1588 = new Solution1588();
        System.out.println(solution1588.sumOddLengthSubarrays(arr));

        System.out.println(7 * 5 + 22 * 9 + 26 * 12 + 12 * 14 + 11 * 15);
    }
}
