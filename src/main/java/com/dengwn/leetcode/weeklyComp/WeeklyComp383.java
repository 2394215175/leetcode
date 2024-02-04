package com.dengwn.leetcode.weeklyComp;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2024-02-04
 **/
public class WeeklyComp383 {

    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int index = 0;
        for (int num : nums) {
            index += num;
            if (index == 0) {
                count++;
            }
        }
        return count;
    }

    public int minimumTimeToInitialState(String word, int k) {
        String s = word;
        int i = 0;
        while (s.length() >= k) {
            s = s.substring(k);
            i++;
            if (word.startsWith(s)) {
                return i;
            }
        }
        return i + 1;
    }

    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][][] temp = new int[m][n][2];
        // i,j 为左上角坐标
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int max = threshold;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int cur = image[i + k][j + l];
                        if (j + l + 1 < n && l < 2) {
                            max = Math.max(max, Math.abs(cur - image[i + k][j + l + 1]));
                        }
                        if (i + k + 1 < m && k < 2) {
                            max = Math.max(max, Math.abs(cur - image[i + k + 1][j + l]));
                        }
                    }
                }

                // 当前区域无法满足条件
                if (max > threshold) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (temp[i + k][j + l][1] == 0) {
                                temp[i + k][j + l][0] = image[i + k][j + l];
                            }
                        }
                    }
                    continue;
                }

                // 计算当前区域总值
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += image[i + k][j + l];
                    }
                }

                // 当前区域内的所有值都变平均值
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (temp[i + k][j + l][1] == 0) {
                            temp[i + k][j + l][0] = sum / 9;
                        } else {
                            temp[i + k][j + l][0] += sum / 9;
                        }
                        temp[i + k][j + l][1]++;
                    }
                }
            }
        }


        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = temp[i][j][0] / (temp[i][j][1] == 0 ? 1 : temp[i][j][1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WeeklyComp383 weeklyComp383 = new WeeklyComp383();
//        int[] nums = {3, 2, -3, -4};
//        System.out.println(weeklyComp383.returnToBoundaryCount(nums));

//        String word = "aab";
//        int k = 2;
//        System.out.println(weeklyComp383.minimumTimeToInitialState(word, k));
        int[][] image = {
                {0, 14, 5, 15},
                {20, 12, 2, 11},
                {8, 11, 0, 3}};
        int threshold = 14;
        System.out.println(Arrays.deepToString(weeklyComp383.resultGrid(image, threshold)));
    }
}
