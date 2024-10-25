package com.dengwn.code.leetcode.solution.t1.h8.d6;

import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2024/9/27
 **/
public class Solution1862 {
    public int sumOfFlooredPairs(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        return 0;
    }
}
