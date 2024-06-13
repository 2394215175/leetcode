package com.dengwn.leetcode.solution.t1.h0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-18
 **/
public class Solution1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n = arr1.length - 1;
        int m = arr2.length - 1;
        // 这里最多有 arr1 和 arr2 最大长度 + 2位
        int len = Math.max(n, m) + 3;
        int[] ans = new int[len];
        // 是否需要进位
        boolean isDel = false;
        // 是否需要借位
        boolean isAdd = false;
        int index = len - 1;
        while (n >= 0 || m >= 0 || isAdd || isDel) {
            int i = n < 0 ? 0 : arr1[n];
            int j = m < 0 ? 0 : arr2[m];
            int k = isDel ? -1 : 0;
            int l = isAdd ? 1 : 0;
            int val = i + j + k + l;
            isDel = val >= 2;
            isAdd = val < 0;
            ans[index] = val >= 0 ? val % 2 : 1;
            n--;
            m--;
            index--;
        }
        // 最后还有去除前导0
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            if (ans[i] == 0) {
                start++;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(ans, start, len);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 1};
        int[] arr2 = {1};
        Solution1073 solution1073 = new Solution1073();
        System.out.println(Arrays.toString(solution1073.addNegabinary(arr1, arr2)));
    }
}
