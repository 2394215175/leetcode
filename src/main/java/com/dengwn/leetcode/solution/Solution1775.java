package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-12-07
 **/
public class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        int diff = Math.abs(sum1 - sum2);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            return del(nums2, nums1, diff);
        } else {
            return del(nums1, nums2, diff);
        }
    }

    public int del(int[] add, int[] sub, int diff) {
        int index1 = 0;
        int index2 = sub.length - 1;
        int ans = 0;
        while (index1 < add.length || index2 >= 0) {
            int delVal;
            if (index1 >= add.length || (6 - add[index1]) < (sub[index2] - 1)) {
                delVal = sub[index2] - 1;
                index2--;
            } else {
                delVal = 6 - add[index1];
                index1++;
            }
            diff -= delVal;
            ans++;
            if (diff <= 0) {
                break;
            }
        }
        return diff > 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution1775 solution1775 = new Solution1775();
        int[] nums1 = {1, 1, 1, 1, 1, 1,1};
        int[] nums2 = {6};
        System.out.println(solution1775.minOperations(nums1, nums2));
    }
}
