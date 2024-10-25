package com.dengwn.code.leetcode.weeklyComp.h3.d4;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-16
 */
public class WeeklyComp341 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int index = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    temp++;
                }
            }
            if (temp > max) {
                index = i;
                max = temp;
            }
        }
        return new int[]{index, max};
    }

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0;
        int size = -1;
        for (int divisor : divisors) {
            int temp = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    temp++;
                }
            }
            if (temp > size) {
                ans = divisor;
                size = temp;
            }
            if (temp == size && divisor < ans) {
                ans = divisor;
            }
        }
        return ans;
    }

    public int addMinimum(String word) {
        int n = word.length();
        if (n == 1) {
            return 2;
        }
        char[] chars = word.toCharArray();
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] <= chars[i - 1]) {
                ans++;
            }
        }
        return ans * 3 - n;
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[] count = new int[n];
        for (int[] trip : trips) {
            boolean[] visited = new boolean[n];
            dfs(lists, trip[0], trip[1], count, visited);
        }

        int ans = 0;



        return 0;
    }

    public int dfs(List<Integer>[] lists, int start, int end, int[] count, boolean[] visited) {
        if (start == end) {
            count[end]++;
            return -1;
        }
        count[start]++;
        visited[start] = true;
        List<Integer> next = lists[start];
        for (Integer n : next) {
            if (!visited[n]) {
                if (dfs(lists, n, end, count, visited) == -1) {
                    return -1;
                } else {
                    count[n]--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WeeklyComp341 weeklyComp341 = new WeeklyComp341();

//        int[] nums = {12};
//        int[] divisors = {10, 16};
//        System.out.println(weeklyComp341.maxDivScore(nums, divisors));
//
//        System.out.println(weeklyComp341.addMinimum("abc"));

        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
        int[] price = {2, 2, 10, 6};
        int[][] trips = {{0, 3}, {2, 1}, {2, 3}};
        System.out.println(weeklyComp341.minimumTotalPrice(n, edges, price, trips));

    }
}
