package com.dengwn.leetcode.solution.t0.h5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution542 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> starts = new LinkedList<>();
        int[][] ans = new int[m][n];
        for (int[] a : ans) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    starts.add(new int[]{i, j});
                }
            }
        }

        while (!starts.isEmpty()) {
            int[] cur = starts.poll();
            int i = cur[0];
            int j = cur[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && ans[ni][nj] > ans[i][j] + 1) {
                    starts.add(new int[]{ni, nj});
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution542 solution542 = new Solution542();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution542.updateMatrix(mat));
    }
}
