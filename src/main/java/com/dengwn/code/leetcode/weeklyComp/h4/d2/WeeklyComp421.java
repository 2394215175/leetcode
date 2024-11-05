package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/10/27
 **/
public class WeeklyComp421 {

    public long maxScore(int[] nums) {
        int n = nums.length;
        long ans = sum(nums);
        for (int i = 0; i < n; i++) {
            int[] arr = new int[n - 1];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                arr[index++] = nums[j];
            }
            ans = Math.max(ans, sum(arr));
        }
        return ans;
    }

    public long sum(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        long lcm = nums[0];
        long gcd = nums[0];
        for (int i = 1; i < n; i++) {
            lcm = lcm(lcm, nums[i]);
            gcd = gcd(gcd, nums[i]);
        }
        return lcm * gcd;
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long b = cnt[1];
            cnt[1] = cnt[0] + cnt[25];
            cnt[0] = cnt[25];
            for (int j = 25; j > 2; j--) {
                cnt[j] = cnt[j - 1];
            }
            cnt[2] = b;
            for (int j = 0; j < 26; j++) {
                cnt[j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[i];
            ans %= MOD;
        }
        return (int) ans;
    }


    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] m = new long[26][26];
        for (int i = 0; i < 26; i++) {
            int c = nums.get(i);
            for (int j = i + 1; j <= i + c; j++) {
                m[i][j % 26] = 1;
            }
        }
        m = pow(m, t);
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) {
            // m 第 i 行的和就是 f[t][i]
            long fti = 0;
            for (long x : m[i]) {
                fti += x;
            }
            ans += fti * cnt[i];
        }
        return (int) (ans % MOD);
    }

    private long[][] pow(long[][] a, int n) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) > 0) {
                res = mul(res, a);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }

    private long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        int l = a[0].length;
        int m = b[0].length;
        long[][] c = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < l; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }


    public static void main(String[] args) {
        WeeklyComp421 weeklyComp421 = new WeeklyComp421();

//        System.out.println(weeklyComp421.maxScore(new int[]{2, 4, 8, 16}));

//        System.out.println(weeklyComp421.lengthAfterTransformations("abcyy", 2));

        String s = "abcyy";
        int t = 2;
        List<Integer> nums = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
        System.out.println(weeklyComp421.lengthAfterTransformations(s, t, nums));
    }
}
