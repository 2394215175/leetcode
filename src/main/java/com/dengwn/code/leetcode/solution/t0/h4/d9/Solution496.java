package com.dengwn.code.leetcode.solution.t0.h4.d9;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            int pre = nums2.length;
            for (int j = 0; j < nums2.length; j++) {
                if (x == nums2[j]) {
                    pre = j;
                }
                if (j > pre && nums2[j] > x) {
                    nums1[i] = nums2[j];
                }
            }
            if (pre == nums2.length) {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
