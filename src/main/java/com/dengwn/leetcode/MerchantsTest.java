package com.dengwn.leetcode;

/**
 * @author: dengwn
 * @date: 2023-06-11
 **/
public class MerchantsTest {

    public boolean magicString(String s) {
        //"ccmm"
        // write code here
        int n = s.length();
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'c') {
                cnt++;
            } else if (chars[i] == 'm') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return cnt == 0;
    }

    public int validNum(int N) {
        // write code here

        int[][] dp = new int[N][2];
        // 第一列为s,第二列为m
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        return dp[N - 1][0] + dp[N - 1][1];
    }




    public static void main(String[] args) {
        MerchantsTest merchantsTest = new MerchantsTest();
        System.out.println(merchantsTest.validNum(30));
    }
}
