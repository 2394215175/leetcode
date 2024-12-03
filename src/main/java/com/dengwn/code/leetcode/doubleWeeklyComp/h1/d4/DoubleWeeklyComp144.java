package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author dengwenning
 * @since 2024/11/23
 **/
public class DoubleWeeklyComp144 {

    public boolean canAliceWin(int n) {
        int m = 10;
        int i = 0;
        while (n >= 0) {
            n -= m;
            i++;
            m--;
        }
        return i % 2 == 0;
    }

    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[][] table = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(table[i], Long.MAX_VALUE);
        }
        // 向后
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                long cost = 0;
                for (int k = 0; k < j; k++) {
                    cost += nextCost[(i + k) % 26];
                }
                table[i][(i + j) % 26] = Math.min(table[i][(i + j) % 26], cost);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                long cost = 0;
                for (int k = 0; k < j; k++) {
                    cost += previousCost[(i - k + 26) % 26];
                }
                table[i][(i - j + 26) % 26] = Math.min(table[i][(i - j + 26) % 26], cost);
            }
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += table[s.charAt(i) - 'a'][t.charAt(i) - 'a'];
        }
        // 向前
        return ans;
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(queries, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while (cur > 0){

            }
        }
        return 0;
    }

    public int maxCollectedFruits(int[][] fruits) {
        int a = 0;
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            a += fruits[i][i];
        }
        // 从[0,n-1]出发
        int[][] nums2 = new int[n][n];
        nums2[0][n - 1] = fruits[0][n - 1];
        int b = nums2[0][n - 1];
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= Math.max(n - i - 1, i + 1); j--) {
                nums2[i][j] = Math.max(nums2[i - 1][j], nums2[i - 1][j - 1]);
                if (j + 1 < n) {
                    nums2[i][j] = Math.max(nums2[i - 1][j + 1], nums2[i][j]);
                }
                nums2[i][j] += fruits[i][j];
                b = Math.max(b, nums2[i][j]);
            }
        }

        int[][] nums3 = new int[n][n];
        nums3[n - 1][0] = fruits[n - 1][0];
        int c = nums3[n - 1][0];
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= Math.max(n - i - 1, i + 1); j--) {
                nums3[j][i] = Math.max(nums3[j][i - 1], nums3[j - 1][i - 1]);
                if (j + 1 < n) {
                    nums3[j][i] = Math.max(nums3[j + 1][i - 1], nums3[j][i]);
                }
                nums3[j][i] += fruits[j][i];
                c = Math.max(c, nums3[j][i]);
            }
        }

        return a + b + c;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp144 doubleWeeklyComp144 = new DoubleWeeklyComp144();

//        System.out.println(doubleWeeklyComp144.canAliceWin(10));

//        String s = "abab";
//        String t = "baba";
//        int[] nextCost = {100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] previousCost = {1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        System.out.println(doubleWeeklyComp144.shiftDistance(s, t, nextCost, previousCost));


        int[] nums = {1, 1, 1, 1};
        int[][] queries = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(doubleWeeklyComp144.maxRemoval(nums, queries));


//        int[][] fruits = {{1,1},{1,1}};
//        System.out.println(doubleWeeklyComp144.maxCollectedFruits(fruits));

    }
}
