package com.dengwn.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
