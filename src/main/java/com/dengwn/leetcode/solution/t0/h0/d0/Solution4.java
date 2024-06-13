package com.dengwn.leetcode.solution.t0.h0.d0;

/**
 * @author: dengwn
 * @date: 2022-12-28
 **/
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;

        int mid = (n + m + 1) / 2;
        int left = 0;
        int right = n;
        while (left < right) {
            int i = (left + right) / 2;
            int j = mid - i;
            if (nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int i = left;
        int j = mid - i;
        int maxLeftVal1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int maxRightVal1 = i == n ? Integer.MAX_VALUE : nums1[i];
        int maxLeftVal2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int maxRightVal2 = j == m ? Integer.MAX_VALUE : nums2[j];

        if ((n + m) % 2 == 1) {
            return Math.max(maxLeftVal1, maxLeftVal2);
        } else {
            return (Math.max(maxLeftVal1, maxLeftVal2) + Math.min(maxRightVal1, maxRightVal2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }
}
