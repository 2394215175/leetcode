package com.dengwn.leetcode.solution.t2.h7.d3;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/25
 **/
public class Solution2372 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer, Integer> maskToIdx = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                mask |= grid[i][j] << j;
            }
            if (mask == 0) {
                return Collections.singletonList(i);
            }
            maskToIdx.put(mask, i);
        }

        for (Map.Entry<Integer, Integer> entry1 : maskToIdx.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : maskToIdx.entrySet()) {
                int key1 = entry1.getKey();
                int key2 = entry2.getKey();
                if ((key1 & key2) == 0) {
                    int val1 = entry1.getValue();
                    int val2 = entry2.getValue();
                    return val1 < val2 ? Arrays.asList(val1, val2) : Arrays.asList(val2, val1);
                }
            }
        }
        return Collections.emptyList();
    }

}
