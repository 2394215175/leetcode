package com.dengwn.code.leetcode.solution.t2.h3.d9;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-03-26
 */
public class Solution2395 {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author dengwenning
     * @since 2024/6/25
     **/
    public static class Solution2372 {
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
}
