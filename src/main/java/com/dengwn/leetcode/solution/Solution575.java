package com.dengwn.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dengwenning
 * @since 2024/6/2
 **/
public class Solution575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        int n = candyType.length;
        for (int j : candyType) {
            type.add(j);
        }
        return Math.min(n / 2, type.size());
    }
}
