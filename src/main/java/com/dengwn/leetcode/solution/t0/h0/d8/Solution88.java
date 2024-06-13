package com.dengwn.leetcode.solution.t0.h0.d8;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[p1 + p2 + 1] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[p1 + p2 + 1] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[p1 + p2 + 1] = nums1[p1--];
            } else {
                nums1[p1 + p2 + 1] = nums2[p2--];
            }
        }

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = {1};
        int[] nums2 = {};
        solution88.merge(nums1, 1, nums2, 0);
    }
}
