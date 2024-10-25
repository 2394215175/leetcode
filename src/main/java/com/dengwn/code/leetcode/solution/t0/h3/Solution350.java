package com.dengwn.code.leetcode.solution.t0.h3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2022-12-14
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Solution350 solution350 = new Solution350();
        System.out.println(solution350.intersect(nums1, nums2));
    }
}
