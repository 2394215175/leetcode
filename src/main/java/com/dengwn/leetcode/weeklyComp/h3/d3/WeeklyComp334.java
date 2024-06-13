package com.dengwn.leetcode.weeklyComp.h3.d3;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-27
 **/
public class WeeklyComp334 {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }

    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long[] temp = new long[n];
        int[] ans = new int[n];
        char[] chars = word.toCharArray();
        temp[0] = (chars[0] - '0') % m;
        ans[0] = temp[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            temp[i] = (temp[i - 1] * 10 + (chars[i] - '0')) % m;
            ans[i] = temp[i] == 0 ? 1 : 0;
        }

        return ans;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int half = (n + 1) / 2;
        int left = 0;
        int right = half;
        int ans = 0;
        while (left < half && right < n) {
            if (nums[right] >= 2 * nums[left]) {
                ans += 2;
                left++;
            }
            right++;
        }
        return ans;
    }


    private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            // 无法「等待」
            return -1;
        }

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        for (; ; ) {
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];
            if (i == m - 1 && j == n - 1) {
                return d;
            }
            for (int[] q : dirs) {
                // 枚举周围四个格子
                int x = i + q[0], y = j + q[1];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    int nd = Math.max(d + 1, grid[x][y]);
                    // nd 必须和 x+y 同奇偶
                    nd += (nd - x - y) % 2;
                    if (nd < dis[x][y]) {
                        // 更新最短路
                        dis[x][y] = nd;
                        pq.add(new int[]{nd, x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WeeklyComp334 weeklyComp334 = new WeeklyComp334();

//        int[] nums1 = {10, 4, 8, 3};
//        System.out.println(Arrays.toString(weeklyComp334.leftRigthDifference(nums1)));
//
//        String word = "998244353";
//        int m = 3;
//        System.out.println(Arrays.toString(weeklyComp334.divisibilityArray(word, m)));
//
//        int[] nums3 = {1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78, 39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10};
//        int[] nums3 = {3, 5, 2, 4};
//        int[] nums3= {9,2,5,4};
//        int[] nums3 = {57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92};
//        System.out.println(weeklyComp334.maxNumOfMarkedIndices(nums3));


        int[][] grid = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};
        System.out.println(weeklyComp334.minimumTime(grid));
    }

}
