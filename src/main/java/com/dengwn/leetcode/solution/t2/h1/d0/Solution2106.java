package com.dengwn.leetcode.solution.t2.h1.d0;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] sum = new int[n + 1];
        int[] coordinate = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + fruits[i - 1][1];
            coordinate[i] = fruits[i - 1][0];
        }
        coordinate[n + 1] = Integer.MAX_VALUE;

        int ans = 0;
        for (int i = 0; i <= k / 2; i++) {
            int left = startPos - k + 2 * i;
            int right = startPos + i;
            int low = lowSearch(coordinate, left);
            int upper = upperSearch(coordinate, right);
            ans = Math.max(ans, sum[upper - 1] - sum[low]);

            left = startPos - i;
            right = startPos + k - 2 * i;
            low = lowSearch(coordinate, left);
            upper = upperSearch(coordinate, right);
            ans = Math.max(ans, sum[upper - 1] - sum[low]);
        }
        return ans;
    }

    public int lowSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (right + left + 1) >> 1;
            if (arr[mid] == target) {
                return mid - 1;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int upperSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (arr[mid] == target) {
                return mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] fruits = {{2, 8}, {6, 3}, {8, 6}};
        int startPos = 5;
        int k = 4;

        Solution2106 solution2106 = new Solution2106();
        System.out.println(solution2106.maxTotalFruits(fruits, startPos, k));

        int[] arr = {0, 2, 6, 8, 10};
//        System.out.println(solution2106.upperSearch(arr, 9));
    }
}
