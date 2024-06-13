package com.dengwn.leetcode.solution.t0.h1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-02-16
 **/
public class Solution149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        double[][] slopes = new double[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                int nx = points[j][0];
                int ny = points[j][1];
                slopes[i][j] = y == ny ? Integer.MAX_VALUE : (nx - x) * 1.0 / (ny - y);
                map.merge(slopes[i][j], 1, Integer::sum);
            }
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                ans = Math.max(ans, entry.getKey() == Integer.MAX_VALUE ? entry.getValue() : entry.getValue() + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution149 solution149 = new Solution149();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution149.maxPoints(points));
    }
}
