package com.dengwn.code.leetcode.solution.t2.h8.d5;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/7/26
 **/
public class Solution2850 {
    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; k++) {
                        from.add(new int[]{i, j});
                    }
                } else if (grid[i][j] == 0) {
                    to.add(new int[]{i, j});
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        List<List<int[]>> permutations = permutations(from);
        for (List<int[]> permutation : permutations) {
            int total = 0;
            for (int i = 0; i < permutation.size(); i++) {
                int[] f = permutation.get(i);
                int[] t = to.get(i);
                total += Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
            }
            ans = Math.min(ans, total);
        }

        return ans;
    }

    public List<List<int[]>> permutations(List<int[]> arr) {
        List<List<int[]>> res = new ArrayList<>();
        permute(arr, 0, res);
        return res;
    }

    private void permute(List<int[]> arr, int start, List<List<int[]>> result) {
        if (start == arr.size()) {
            result.add(new ArrayList<>(arr));
        }
        for (int i = start; i < arr.size(); i++) {
            swap(arr, start, i);
            permute(arr, start + 1, result);
            swap(arr, start, i);
        }
    }

    private void swap(List<int[]> arr, int i, int j) {
        int[] temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
