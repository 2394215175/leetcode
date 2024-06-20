package com.dengwn.leetcode.solution.t2.h0.d3;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums1) {
            map.put(nums1[num], 1);
        }
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) != 2) {
                res.add(num);
            }
            map.put(num, 2);
        }
        for (int num : nums3) {
            if (map.get(num) != null && map.get(num) != 3 && !res.contains(num)) {
                res.add(num);
            }
            map.put(num, 3);
        }
        return res;
    }

    public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        int[] ints = new int[101];

        List<Integer> res = new ArrayList<>();
        for (int num : nums1) {
            ints[num] = 1;
        }
        for (int num : nums2) {
            if (ints[num] == 1) {
                res.add(num);
            }
            ints[num] = 2;
        }
        for (int num : nums3) {
            if ((ints[num] == 1 || ints[num] == 2) && !res.contains(num)) {
                res.add(num);
            }
            ints[num] = 3;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
