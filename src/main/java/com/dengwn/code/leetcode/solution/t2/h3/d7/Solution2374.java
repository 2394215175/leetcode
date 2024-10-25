package com.dengwn.code.leetcode.solution.t2.h3.d7;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2024/9/23
 **/
public class Solution2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] map = new long[n];
        int ans = 0;
        long score = 0;
        for (int i = 0; i < n; i++) {
            map[edges[i]] += i;
            if (map[edges[i]] > score || (edges[i] < ans && map[edges[i]] == score)) {
                ans = edges[i];
                score = map[edges[i]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2374 solution2374 = new Solution2374();

        int[] edges = {2, 0, 0, 2};
        System.out.println(solution2374.edgeScore(edges));
    }
}
