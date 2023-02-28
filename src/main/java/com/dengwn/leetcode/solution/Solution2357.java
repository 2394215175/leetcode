package com.dengwn.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-02-24
 **/
public class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
