package com.dengwn.code.leetcode.solution.t2.h3.d5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-06-06
 **/
public class Solution2352 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> row = new HashMap<>(n);
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(ints[j]).append("_");
            }
            row.merge(sb.toString(), 1, Integer::sum);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[i]).append("_");
            }
            String s = sb.toString();
            if (row.containsKey(s)){
                ans += row.get(s);
            }
        }

        return ans;
    }
}
