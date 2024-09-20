package com.dengwn.leetcode.solution.t2.h5.d5;

import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2024/9/11
 **/
public class Solution2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int prizePosition : prizePositions) {
            map.merge(prizePosition, 1, Integer::sum);
        }
        return 0;
    }
}
