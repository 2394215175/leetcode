package com.dengwn.leetcode.solution.t1.h0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-05-15
 **/
public class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int j = 0; j < m; j++) {
                stringBuilder1.append(matrix[i][j]);
                stringBuilder2.append(matrix[i][j] ^ 1);
            }
            map.merge(stringBuilder1.toString(), 1, Integer::sum);
            map.merge(stringBuilder2.toString(), 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans = Math.max(entry.getValue(), ans);
        }
        return ans;
    }

    public static void main(String[] args) {

    }


}
