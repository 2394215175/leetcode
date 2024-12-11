package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *
 * @author dengwenning
 * @since 2024/12/8
 **/
public class DoubleWeeklyComp145 {

    public int minOperations(int[] nums, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (num == k) {
                continue;
            }
            treeSet.add(num);
            if (num < k) {
                return -1;
            }
        }
        return treeSet.size();
    }

    List<Integer> list;
    int k;

    public int findMinimumTime(List<Integer> strength, int K) {
        int n = strength.size();
        boolean[] visited = new boolean[n];
        list = strength;
        k = K;
        return dfs(visited, 1);
    }

    public int dfs(boolean[] visited, int X) {
        if ((X - 1) / k == visited.length) {
            return 0;
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            ans = Math.min(ans, dfs(visited, X + k) + (list.get(i) + X - 1) / X);
            visited[i] = false;
        }
        return ans;
    }

    public int minOperations(int n, int m) {
        int len = String.valueOf(n).length();
        boolean[][] dp = new boolean[len][9];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][n % 10] = true;
        return 0;
    }

    public boolean isPri(int n){
        if (n <= 2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp145 doubleWeeklyComp145 = new DoubleWeeklyComp145();
        List<Integer> list = Arrays.asList(7, 3, 6, 18, 22, 50);
        System.out.println(doubleWeeklyComp145.findMinimumTime(list, 4));
    }
}
