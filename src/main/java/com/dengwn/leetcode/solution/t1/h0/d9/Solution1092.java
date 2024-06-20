package com.dengwn.leetcode.solution.t1.h0.d9;

/**
 * @author: dengwn
 * @date: 2023-03-28
 **/
public class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        int na = dp[n][m];
        char[] ans = new char[na];
        for (int i = n - 1, j = m - 1, k = na - 1; ; ) {
            if (i < 0) {
                // s 是空串，剩余的 t 就是最短公共超序列
                System.arraycopy(t, 0, ans, 0, j + 1);
                break;
            }
            if (j < 0) {
                // t 是空串，剩余的 s 就是最短公共超序列
                System.arraycopy(s, 0, ans, 0, i + 1);
                break; // 相当于递归边界
            }
            if (s[i] == t[j]) {
                // 公共超序列一定包含 s[i]
                // 倒着填 ans
                ans[k--] = s[i--];
                // 相当于继续递归 makeAns(i - 1, j - 1)
                --j;
            } else if (dp[i + 1][j + 1] == dp[i][j + 1] + 1) {
                // 相当于继续递归 makeAns(i - 1, j)
                ans[k--] += s[i--];
            } else {
                // 相当于继续递归 makeAns(i, j - 1)
                ans[k--] += t[j--];
            }
        }
        return new String(ans);
    }

    public String shortestCommonSupersequence1(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; ++i) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int t1 = 0, t2 = 0;
        while (t1 < n && t2 < m) {
            if (str1.charAt(t1) == str2.charAt(t2)) {
                res.append(str1.charAt(t1));
                ++t1;
                ++t2;
            } else if (dp[t1 + 1][t2] == dp[t1][t2] - 1) {
                res.append(str1.charAt(t1));
                ++t1;
            } else if (dp[t1][t2 + 1] == dp[t1][t2] - 1) {
                res.append(str2.charAt(t2));
                ++t2;
            }
        }
        if (t1 < n) {
            res.append(str1.substring(t1));
        } else if (t2 < m) {
            res.append(str2.substring(t2));
        }
        return res.toString();
    }

    public String shortestCommonSupersequence2(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        str1 = " " + str1;
        str2 = " " + str2;
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i] == s2[j]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i == 0) {
                sb.append(s2[j--]);
            } else if (j == 0) {
                sb.append(s1[i--]);
            } else {
                if (s1[i] == s2[j]) {
                    sb.append(s1[i]);
                    i--;
                    j--;
                } else if (f[i][j] == f[i - 1][j]) {
                    sb.append(s1[i--]);
                } else {
                    sb.append(s2[j--]);
                }
            }
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Solution1092 solution1092 = new Solution1092();
        System.out.println(solution1092.shortestCommonSupersequence2("abac", "cab"));
    }
}
