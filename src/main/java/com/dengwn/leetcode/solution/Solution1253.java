package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2023-06-30
 **/
public class Solution1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        int n = colsum.length;
        int[][] ret = new int[2][n];

        for (int x : colsum) {
            sum += x;
        }
        if (upper + lower != sum) {
            return new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int x = colsum[i];
            ret[0][i] = x == 2 || (x == 1 && upper >= lower) ? 1 : 0;
            ret[1][i] = x == 2 || (x == 1 && upper < lower) ? 1 : 0;
            upper -= ret[0][i];
            lower -= ret[1][i];
        }

        return upper == 0 && lower == 0 ? new ArrayList(Arrays.asList(ret[0], ret[1])) : new ArrayList();
    }

    public static void main(String[] args) {
        int upper = 2;
        int lower = 9;
        int[] colsum = {1, 1, 2, 1, 0, 0, 0, 0, 2, 1, 1, 1, 1};
        Solution1253 solution1253 = new Solution1253();

        System.out.println(solution1253.reconstructMatrix(upper, lower, colsum));
    }
}
