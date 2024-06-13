package com.dengwn.leetcode.solution.t0.h2;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-05
 **/
public class Solution233 {
    public int countDigitOne(int n) {
        int ans = 0;
        for (int i = 1; n / i > 0; i *= 10) {
            int k = n / i;
            // 取高位
            int h = k / 10;
            int cur = k % 10;
            ans += h * i;
            if (cur > 1) {
                ans += i;
            } else if (cur == 1) {
                ans += n - k * i + 1;
            }
        }
        return ans;
    }

    char s[];
    int dp[][];

    public int countDigitOne1(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][m];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true);
    }

    int f(int i, int cnt1, boolean isLimit) {
        if (i == s.length){
            return cnt1;
        }
        if (!isLimit && dp[i][cnt1] >= 0){
            return dp[i][cnt1];
        }
        int res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d){
            // 枚举要填入的数字 d
            res += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit){
            dp[i][cnt1] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution233 solution233 = new Solution233();
        System.out.println(solution233.countDigitOne1(13));
    }
}
