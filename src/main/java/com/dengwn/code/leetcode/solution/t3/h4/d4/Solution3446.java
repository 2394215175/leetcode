package com.dengwn.code.leetcode.solution.t3.h4.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2025/2/11
 **/
public class Solution3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        List<Integer>[] arrs = new List[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arrs[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrs[i - j + n].add(grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            arrs[i].sort((o1, o2) -> o1 - o2);
        }
        for (int i = n; i < 2 * n; i++) {
            arrs[i].sort((o1, o2) -> o2 - o1);
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arrs[i - j + n].get(Math.min(i, j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        Solution3446 solution3446 = new Solution3446();
        System.out.println(Arrays.deepToString(solution3446.sortMatrix(grid)));
    }
}
