package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-04-20
 **/
public class Solution1187 {
    static final int INF = 0x3f3f3f3f;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int n = arr1.length, m = 0;
        for (int i = 1; i < arr2.length; ++i) {
            if (arr2[m] != arr2[i]) {
                arr2[++m] = arr2[i];
            }
        }
        int[][] dp = new int[n + 1][Math.min(m, n) + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, m); j++) {
                /* 如果当前元素大于序列的最后一个元素 */
                if (arr1[i - 1] > dp[i - 1][j]) {
                    dp[i][j] = arr1[i - 1];
                }
                if (j > 0 && dp[i - 1][j - 1] != INF) {
                    /* 查找严格大于 dp[i - 1][j - 1] 的最小元素 */
                    int idx = findMinOver(arr2, j - 1, m, dp[i - 1][j - 1]);
                    if (idx <= m) {
                        dp[i][j] = Math.min(dp[i][j], arr2[idx]);
                    }
                }
                if (i == n && dp[i][j] != INF) {
                    return j;
                }
            }
        }
        return -1;
    }

    public int findMinOver(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + right >> 1;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1187 solution1187 = new Solution1187();
        int[] arr1 = {1,5,3,6,7};
        int[] arr2 = {1, 3, 2, 4};
        System.out.println(solution1187.makeArrayIncreasing(arr1, arr2));
    }

}
