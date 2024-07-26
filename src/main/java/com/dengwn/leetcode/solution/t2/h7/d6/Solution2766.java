package com.dengwn.leetcode.solution.t2.h7.d6;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/7/24
 **/
public class Solution2766 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            set.remove(from);
            set.add(to);
        }
        return new ArrayList<>(set);
    }
}
