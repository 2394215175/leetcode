package com.dengwn.leetcode.solution.t2.h3.d2;

/**
 * @author dengwenning
 * @since 2024/7/5
 **/
public class Solution2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff1 = new int[n];
        int[] diff2 = new int[n];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff1[i] = nums1[i] - nums2[i];
            diff2[i] = nums2[i] - nums1[i];
        }
        int mina = 0, minb = 0;
        int maxa = 0, maxb = 0;
        int suma = 0, sumb = 0;
        for (int i = 0; i < n; i++) {
            suma += diff1[i];
            mina = Math.min(mina, suma);
            maxa = Math.max(maxa, suma - mina);
            sumb += diff2[i];
            minb = Math.min(minb, sumb);
            maxb = Math.max(maxb, sumb - minb);
        }
        return Math.max(sum2 + maxa, sum1 + maxb);
    }

    public static void main(String[] args) {
        Solution2321 solution2321 = new Solution2321();
        int[] nums1 = {28, 34, 38, 14, 30, 31, 23, 7, 28, 3};
        int[] nums2 = {42, 35, 7, 6, 24, 30, 14, 21, 20, 34};
        System.out.println(solution2321.maximumsSplicedArray(nums1, nums2));
    }
}
