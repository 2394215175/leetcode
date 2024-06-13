package com.dengwn.leetcode.doubleWeeklyComp.h1.d3;

import java.util.*;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/6/4
 **/
public class DoubleWeeklyComp130 {

    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < m; i++) {
            if (grid[0][i - 1] == grid[0][i]) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            int t = grid[0][i];
            for (int j = 1; j < n; j++) {
                if (grid[j][i] != t) {
                    return false;
                }
            }
        }
        return true;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (points[i][j] < 0) {
                    points[i][j] = -points[i][j];
                }
            }
            char c = s.charAt(i);
            List<int[]> list = map.getOrDefault(c, new LinkedList<>());
            list.add(points[i]);
            map.put(c, list);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<int[]>> entry : map.entrySet()) {
            List<int[]> value = entry.getValue();
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            if (value.size() != 1) {
                for (int i = 0; i < value.size(); i++) {
                    int x = value.get(i)[0];
                    int y = value.get(i)[1];
                    int max = Math.max(x, y);
                    if (max < first) {
                        second = first;
                        first = max;
                    } else if (max < second) {
                        second = max;
                    }
                }
                min = Math.min(min, second);
            }
        }

        int ans = 0;
        for (int[] point : points) {
            if (point[0] < min && point[1] < min) {
                ans++;
            }
        }
        return ans;
    }

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int ans = n;
        char[] array = s.toCharArray();

        int l = 0;
        int r = 1;
        while (l < n){
            int right = r;
            while (right < n){
                int[] cnt = new int[26];
                for (int i = l; i < right; i++) {
                    cnt[array[i] - 'a']++;
                }
                if (check(cnt)){
                    r = right;
                }
                right++;
            }
            l = r + 1;
            ans++;
        }
        return ans;
    }

    private boolean check(int[] t) {
        int a = 0;
        for (int i = 0; i < 26; i++) {
            if (t[i] == 0) {
                continue;
            }
            if (a != 0 && a != t[i]) {
                return false;
            }
            a = t[i];
        }
        return true;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp130 doubleWeeklyComp130 = new DoubleWeeklyComp130();

//        int[][] points = {{-1, -4}, {16, -8}, {13, -3}, {-12, 0}};
//        String s = "abda";
//        System.out.println(doubleWeeklyComp130.maxPointsInsideSquare(points, s));

        System.out.println(doubleWeeklyComp130.minimumSubstringsInPartition("fabccddg"));

    }
}
