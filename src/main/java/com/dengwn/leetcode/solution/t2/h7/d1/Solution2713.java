package com.dengwn.leetcode.solution.t2.h7.d1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author dengwenning
 * @since 2024/6/19
 **/
public class Solution2713 {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 相同元素放在同一组，统计位置
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (List<int[]> pos : g.values()) {
            // 先把最大值算出来，再更新 rowMax 和 colMax
            int[] mx = new int[pos.size()];
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                mx[k] = Math.max(rowMax[i], colMax[j]) + 1;
                ans = Math.max(ans, mx[k]);
            }
            for (int k = 0; k < pos.size(); k++) {
                int[] p = pos.get(k);
                int i = p[0];
                int j = p[1];
                // 更新第 i 行的最大 f 值
                rowMax[i] = Math.max(rowMax[i], mx[k]);
                // 更新第 j 列的最大 f 值
                colMax[j] = Math.max(colMax[j], mx[k]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 1}, {3, 4}};
        Solution2713 solution2713 = new Solution2713();
        solution2713.maxIncreasingCells(mat);

    }
}
