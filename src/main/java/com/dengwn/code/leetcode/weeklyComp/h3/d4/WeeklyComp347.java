package com.dengwn.code.leetcode.weeklyComp.h3.d4;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: dengwn
 * @date: 2023-05-30
 **/
public class WeeklyComp347 {

    public String removeTrailingZeros(String num) {
        int n = num.length();
        int index = n;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                index = i;
            } else {
                break;
            }
        }
        return num.substring(0, index);
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 计算左上元素
                HashSet<Integer> set1 = new HashSet<>();
                int tempI = i - 1;
                int tempJ = j - 1;
                while (tempI >= 0 && tempJ >= 0) {
                    set1.add(grid[tempI--][tempJ--]);
                }
                // 计算右下元素
                HashSet<Integer> set2 = new HashSet<>();
                tempI = i + 1;
                tempJ = j + 1;
                while (tempI < n && tempJ < m) {
                    set2.add(grid[tempI++][tempJ++]);
                }
                ans[i][j] = Math.abs(set1.size() - set2.size());
            }
        }
        return ans;
    }

    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp347 weeklyComp347 = new WeeklyComp347();

//        String num = "123";
//        System.out.println(weeklyComp347.removeTrailingZeros(num));

        int[][] grid = {{1, 2, 3}, {3, 1, 5}, {3, 2, 1}};
        System.out.println(Arrays.deepToString(weeklyComp347.differenceOfDistinctValues(grid)));
    }
}
