package com.dengwn.leetcode.weeklyComp.h4.d0;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/7/7
 **/
public class WeeklyComp405 {

    public String getEncryptedString(String s, int k) {
        char[] array = s.toCharArray();
        int n = array.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = array[(i + k) % n];
        }
        return new String(ans);
    }

    List<String> ans = new ArrayList<>();
    int n;

    public List<String> validStrings(int n) {
        this.n = n;
        char[] chars = new char[n];
        chars[0] = '1';
        dfs(1, chars);
        chars[0] = '0';
        dfs(1, chars);
        return ans;
    }

    public void dfs(int i, char[] chars) {
        if (i == n) {
            ans.add(new String(chars));
            return;
        }
        if (chars[i - 1] == '1') {
            chars[i] = '0';
            dfs(i + 1, chars);
        }
        chars[i] = '1';
        dfs(i + 1, chars);
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][2];
        if (grid[0][0] == 'X') {
            dp[0][0][0] = 1;
        } else if (grid[0][0] == 'Y') {
            dp[0][0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == 'X') {
                dp[i][0][0] = dp[i - 1][0][0] + 1;
                dp[i][0][1] = dp[i - 1][0][1];
            } else if (grid[i][0] == 'Y') {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = dp[i - 1][0][1] + 1;
            } else {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = dp[i - 1][0][1];
            }
        }
        for (int j = 1; j < m; j++) {
            if (grid[0][j] == 'X') {
                dp[0][j][0] = dp[0][j - 1][0] + 1;
                dp[0][j][1] = dp[0][j - 1][1];
            } else if (grid[0][j] == 'Y') {
                dp[0][j][0] = dp[0][j - 1][0];
                dp[0][j][1] = dp[0][j - 1][1] + 1;
            } else {
                dp[0][j][0] = dp[0][j - 1][0];
                dp[0][j][1] = dp[0][j - 1][1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 'X') {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1];
                } else if (grid[i][j] == 'Y') {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1] + 1;
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j][0] == dp[i][j][1] && dp[i][j][0] > 0) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public int minimumCost(String target, String[] words, int[] costs) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if (treeMap.containsKey(words[i])) {
                treeMap.put(words[i], Math.min(treeMap.get(words[i]), costs[i]));
            } else {
                treeMap.put(words[i], costs[i]);
            }
        }
        int m = target.length();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == (int) 1e9) {
                    continue;
                }
                String sub = target.substring(j, i);
                if (treeMap.containsKey(sub)) {
                    dp[i] = Math.min(dp[i], dp[j] + treeMap.get(sub));
                }
            }
        }
        return dp[m] == (int) 1e9 ? -1 : dp[m];
    }

    public static void main(String[] args) {
        WeeklyComp405 weeklyComp405 = new WeeklyComp405();

//        System.out.println(weeklyComp405.validStrings(3));

//        char[][] grid = {{'X', 'Y', '.'}, {'Y', '.', '.'}};
//        System.out.println(weeklyComp405.numberOfSubmatrices(grid));

        String target = "aaaa";
        String[] words = {"z", "z", "z", "wtz", "b"};
        int[] costs = {1, 10, 4, 7, 6};
        System.out.println(weeklyComp405.minimumCost(target, words, costs));

//        System.out.println("b".compareTo("a"));

    }
}
