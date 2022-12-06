package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-05
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int index1 = 0;
        int index2 = 0;
        int[] copy = Arrays.copyOf(nums1, m);
        for (int i = 0; i < m + n; i++) {
            if (index1 >= m) {
                nums1[i] = nums2[index2];
                index2++;
                continue;
            }
            if (index2 >= n) {
                nums1[i] = copy[index1];
                index1++;
                continue;
            }
            if (copy[index1] <= nums2[index2]) {
                nums1[i] = copy[index1];
                index1++;
            } else {
                nums1[i] = nums2[index2];
                index2++;
            }
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        solution88.merge(nums1, 1, nums2, 1);
    }
}
