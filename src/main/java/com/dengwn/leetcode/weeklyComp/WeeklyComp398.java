package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/19
 **/
public class WeeklyComp398 {

    public boolean isArraySpecial(int[] nums) {
        boolean odd = nums[0] % 2 == 0;

        for (int i = 1; i < nums.length; i++) {
            boolean a = nums[i] % 2 == 0;
            if (a == odd) {
                return false;
            }
            odd = a;
        }
        return true;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[][] temp = new int[m][3];
        for (int i = 0; i < m; i++) {
            temp[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));

        boolean[] ans = new boolean[m];
        Arrays.fill(ans, true);
        int index = 0;
        boolean a = nums[0] % 2 == 0;
        for (int i = 1; i < n; i++) {
            boolean b = nums[i] % 2 == 0;
            if (a == b) {
                while (index < m && temp[index][0] <= i - 1) {
                    if (temp[index][1] >= i) {
                        ans[temp[index][2]] = false;
                    }
                    index++;
                }
            }
            a = b;
        }
        return ans;
    }

    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        long ans = 0;

        String s = Integer.toString(nums[0]);
        int m = s.length();

        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = Integer.toString(nums[i]);
        }

        for (int i = 0; i < m; i++) {
            long[] table = new long[10];
            for (int j = 0; j < n; j++) {
                table[ss[j].charAt(i) - '0']++;
            }

            ans += (long) n * (n - 1) / 2;
            for (int j = 0; j < 10; j++) {
                ans -= table[j] * (table[j] - 1) / 2;
            }
        }

        return ans;
    }

    int k;
    Map<String, Integer> memo;

    private static final int MX = 31;
    private static final int[][] c = new int[MX][MX];

    static {
        for (int i = 0; i < MX; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
    }


    public int waysToReachStair(int k) {
        int ans = 0;
        for (int j = 0; j < 30; j++) {
            int m = (1 << j) - k;
            if (0 <= m && m <= j + 1) {
                long num = 1;
                for (int i = j + 1, v = 1; v < m + 1; i--, v++) {
                    num *= i;
                    num /= v;
                }
                ans += (int) num;
            }
        }
        return ans;
    }

    public int dfs(int i, int j, boolean isA) {
        if (i > k + 1) {
            return 0;
        }
        String p = i + "_" + j + "_" + isA;
        if (memo.containsKey(p)) {
            return memo.get(p);
        }
        int ans = 0;
        if (i == k) {
            ans++;
        }
        ans += dfs(i + (1 << j), j + 1, false);
        if (!isA && i > 0) {
            ans += dfs(i - 1, j, true);
        }
        memo.put(p, ans);
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp398 weeklyComp398 = new WeeklyComp398();

        System.out.println(weeklyComp398.waysToReachStair(4083));
    }
}
