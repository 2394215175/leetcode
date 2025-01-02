package com.dengwn.code.leetcode.solution.t0.h3.d4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2022-12-10
 **/
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        Set<Integer> res = new HashSet<>(length1);
        Set<Integer> set = new HashSet<>(length1);
        for (int i = 0; i < length1; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 7, 9, 7, 6, 7};
        int[] nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        Solution349 solution349 = new Solution349();
        System.out.println(solution349.intersection(nums1, nums2));
    }
}
