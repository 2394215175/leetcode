package com.dengwn.leetcode.doubleWeeklyComp;

/**
 * @author dengwn
 * @date: 2023-06-24
 */
public class DoubleWeeklyComp107 {

    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                StringBuilder reverse = new StringBuilder(words[i]).reverse();
                if (reverse.toString().equals(words[j])) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public int longestString(int x, int y, int z) {
        int cnt = x == y ? x + y : 2 * Math.min(x, y) + 1;
        return 2 * (cnt + z);
    }

    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = words.length;
                } else {
                    for (int k = j - 1; k >= i; k--) {
                        
                    }
                }
            }
        }
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

    }

    public static void main(String[] args) {
        DoubleWeeklyComp107 doubleWeeklyComp107 = new DoubleWeeklyComp107();

//        String[] words = {"aa","ab"};
//        System.out.println(doubleWeeklyComp107.maximumNumberOfStringPairs(words));

        System.out.println(doubleWeeklyComp107.longestString(2, 2, 2));

//        String[] words = {"a", "bc", "b", "c"};
//        System.out.println(doubleWeeklyComp107.minimizeConcatenatedLength(words));
    }
}
