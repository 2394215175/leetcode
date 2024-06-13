package com.dengwn.leetcode.solution.t1.h5;

/**
 * @author dengwn
 * @date: 2023-03-25
 */
public class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            --right;
        }
        if (right == 0) {
            return 0;
        }

        int ans = right;
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < n && arr[right] < arr[left]) {
                ++right;
            }
            // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
            ans = Math.min(ans, right - left - 1);
        }

        return ans;
    }


    public int findLengthOfShortestSubarray1(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        int ans = n - left - 1;
        for (int right = n - 1; right == n - 1 || arr[right + 1] >= arr[right]; right--) {
            while (left >= 0 && arr[right] < arr[left]) {
                left--;
            }
            ans = Math.min(ans, right - left - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1};
        Solution1574 solution1574 = new Solution1574();
        System.out.println(solution1574.findLengthOfShortestSubarray1(arr));
    }
}
