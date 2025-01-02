package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class DoubleWeeklyComp146 {

    public int countSubarrays(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                ans++;
            }
        }
        return ans;
    }

    public int countPathsWithXorValue(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        HashMap<Integer, Integer>[][] map = new HashMap[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = new HashMap<>();
            }
        }
        map[0][0].put(grid[0][0], 1);
        for (int i = 1; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : map[i - 1][0].entrySet()) {
                map[i][0].merge(entry.getKey() ^ grid[i][0], entry.getValue(), Integer::sum);
            }
        }

        for (int i = 1; i < m; i++) {
            for (Map.Entry<Integer, Integer> entry : map[0][i - 1].entrySet()) {
                map[0][i].merge(entry.getKey() ^ grid[0][i], entry.getValue(), Integer::sum);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (Map.Entry<Integer, Integer> entry : map[i - 1][j].entrySet()) {
                    int key = entry.getKey() ^ grid[i][j];
                    map[i][j].merge(key, entry.getValue(), Integer::sum);
                    map[i][j].put(key, map[i][j].get(key) % 1000000007);
                }
                for (Map.Entry<Integer, Integer> entry : map[i][j - 1].entrySet()) {
                    int key = entry.getKey() ^ grid[i][j];
                    map[i][j].merge(entry.getKey() ^ grid[i][j], entry.getValue(), Integer::sum);
                    map[i][j].put(key, map[i][j].get(key) % 1000000007);
                }
            }
        }
        return map[n - 1][m - 1].getOrDefault(k, 0);
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (o1, o2) -> o1[1] == o2[1] ? o2[3] - o1[3] : o1[1] - o2[1]);
        int pre = 0;
        int x = 0;
        for (int[] rectangle : rectangles) {
            if (rectangle[1] >= pre) {
                pre = rectangle[3];
                x++;
            }
            if (rectangle[3] > pre){
                pre = rectangle[3];
            }
        }
        Arrays.sort(rectangles, (o1, o2) -> o1[0] == o2[0] ? o2[2] - o1[2] : o1[0] - o2[0]);
        pre = 0;
        int y = 0;
        for (int[] rectangle : rectangles) {
            if (rectangle[0] >= pre) {
                pre = rectangle[2];
                y++;
            }
            if (rectangle[2] > pre){
                pre = rectangle[2];
            }
        }
        return x >= 3 || y >= 3;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp146 doubleWeeklyComp146 = new DoubleWeeklyComp146();
        int[][] rectangles = {
                {0, 2, 2, 4},
                {1, 0, 3, 2},
                {2, 2, 3, 4},
                {3, 0, 4, 2},
                {3, 2, 4, 4}
        };
        System.out.println(doubleWeeklyComp146.checkValidCuts(4, rectangles));
    }
}
