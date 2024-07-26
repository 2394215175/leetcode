package com.dengwn.leetcode.solution.t2.h9.d5;

/**
 * @author dengwenning
 * @since 2024/7/16
 **/
public class Solution2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] cnt1 = new boolean[101];
        boolean[] cnt2 = new boolean[101];
        int num1 = 0;
        int num2 = 0;
        for (int i : nums1) {
            cnt1[i] = true;
        }
        for (int i : nums2) {
            cnt2[i] = true;
            if (cnt1[i]) {
                num2++;
            }
        }
        for (int i : nums1) {
            if (cnt2[i]) {
                num1++;
            }
        }
        return new int[]{num1, num2};
    }
}
