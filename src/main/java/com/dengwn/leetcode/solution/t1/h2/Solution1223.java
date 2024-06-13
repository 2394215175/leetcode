package com.dengwn.leetcode.solution.t1.h2;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-02-10
 **/
public class Solution1223 {
    private static final int MOD = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int m = rollMax.length;
        int[][] f = new int[n][m];
        int[] s = new int[n];
        Arrays.fill(f[0], 1);
        s[0] = m;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int res = s[i - 1], mx = rollMax[j];
                if (i > mx) {
                    res -= s[i - mx - 1] - f[i - mx - 1][j];
                } else if (i == mx) {
                    --res;
                }
                // 防止出现负数
                f[i][j] = (res % MOD + MOD) % MOD;
                s[i] = (s[i] + f[i][j]) % MOD;
            }
        }
        return s[n - 1];
    }

    public int dieSimulator1(int n, int[] rollMax) {
        int sum = (int) Math.pow(6, n);
        for (int max : rollMax) {
            int a = n - max;
            sum -= (int)(Math.pow(6, (a - 1)) * a - Math.pow(6, (a - 2)) * (a - 1));
        }
        return sum;
    }


    public static void main(String[] args) {
        int n = 2;
        int[] rollMax = {1,1,2,2,2,3};
//        int[] rollMax = {1,1,1,1,1,1};
//        int n = 2;
        Solution1223 solution1223 = new Solution1223();
        System.out.println(solution1223.dieSimulator(n, rollMax));
        System.out.println(solution1223.dieSimulator1(n, rollMax));
    }
}
