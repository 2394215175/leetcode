package com.dengwn.leetcode.solution.t1.h9.d3;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/27
 **/
public class Solution1931 {

    final int MOD = 1000000007;
    int[][] memo;

    public int colorTheGrid(int m, int n) {
        int max = (int) Math.pow(3, m);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < max; i++) {
            if (isValid(i, m)) {
                set.add(i);
            }
        }
        int size = set.size();
        Map<Integer, Integer> idxMap = new HashMap<>();
        long[][] dp = new long[n][size];
        int idx = 0;
        for (Integer i : set) {
            dp[0][idx] = 1;
            idxMap.put(idx, i);
            idx++;
        }
        memo = new int[size][size];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (memo[j][k] != 0) {
                        if (memo[j][k] == 1) {
                            dp[i][j] += dp[i - 1][k];
                            dp[i][j] %= MOD;
                        }
                    } else {
                        if (isValid(idxMap.get(k), idxMap.get(j), m)) {
                            memo[j][k] = 1;
                            dp[i][j] += dp[i - 1][k];
                            dp[i][j] %= MOD;
                        } else {
                            memo[j][k] = 2;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (long value : dp[n - 1]) {
            ans += value;
            ans %= MOD;
        }

        return (int) ans;
    }

    public boolean isValid(int num1, int num2, int m) {
        for (int i = 0; i < m; i++) {
            int mod1 = num1 % 3;
            int mod2 = num2 % 3;
            if (mod1 == mod2) {
                return false;
            }
            num1 /= 3;
            num2 /= 3;
        }
        return true;
    }

    public boolean isValid(int num, int m) {
        int mod = -1;
        for (int i = 0; i < m; i++) {
            if (mod == num % 3) {
                return false;
            }
            mod = num % 3;
            num /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1931 solution1931 = new Solution1931();
        System.out.println(solution1931.colorTheGrid(3, 49));
    }
}
