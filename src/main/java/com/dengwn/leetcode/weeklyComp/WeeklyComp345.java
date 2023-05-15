package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-05-14
 */
public class WeeklyComp345 {
    public int[] circularGameLosers(int n, int k) {
        int[] temp = new int[n];
        int index = 1;
        int cur = 0;
        temp[cur]++;
        do {
            cur += index * k;
            cur %= n;
            temp[cur]++;
            index++;
        } while (temp[cur] != 2);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0) {
                ans.add(i + 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        boolean[] dp1 = new boolean[n + 1];
        boolean[] dp2 = new boolean[n + 1];
        dp1[0] = true;
        dp2[0] = false;
        for (int i = 0; i < n; i++) {
            if (derived[i] == 1) {
                dp1[i + 1] = !dp1[i];
                dp2[i + 1] = !dp2[i];
            } else {
                dp1[i + 1] = dp1[i];
                dp2[i + 1] = dp2[i];
            }
        }
        return dp1[n] == dp1[0] || dp2[n] == dp2[0];
    }

    int[][] d = {{-1, -1}, {0, -1}, {1, -1}};

    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int ans = 0;
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < 3; k++) {
                    int li = i + d[k][0];
                    int lj = j + d[k][1];
                    if (li >= 0 && li < n && grid[i][j] > grid[li][lj]) {
                        dp[i][j] = Math.max(dp[i][j], dp[li][lj] + 1);
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        return ans;
    }

    int[] parent;

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }


    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        } else {
            parent[rootX] = rootY;
        }
        return true;
    }


    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp345 weeklyComp345 = new WeeklyComp345();

//        int n = 4;
//        int k = 4;
//        System.out.println(Arrays.toString(weeklyComp345.circularGameLosers(n, k)));

//        int[] derived = {1, 0};
//        System.out.println(weeklyComp345.doesValidArrayExist(derived));

//        int[][] grid = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
//        System.out.println(weeklyComp345.maxMoves(grid));

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(weeklyComp345.countCompleteComponents(n, edges));
    }
}
