package com.dengwn.leetcode.solution.t1.h0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2023-05-23
 **/
public class Solution1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] arr = new int[n][2];
        int[] used = new int[20001];
        for (int i = 0; i < n; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }

        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        int ans = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (used[arr[i][1]] < useLimit) {
                ans += arr[i][0];
                used[arr[i][1]]++;
                num++;
                if (num == numWanted) {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1090 solution1090 = new Solution1090();
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 3, 3, 3, 2};
        int numWanted = 3;
        int useLimit = 2;
        System.out.println(solution1090.largestValsFromLabels(values, labels, numWanted, useLimit));

    }
}
