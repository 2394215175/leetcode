package com.dengwn.leetcode.doubleWeeklyComp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class DoubleWeeklyComp103 {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max * k + k * (k - 1) / 2;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] arr = new int[n + 1];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            arr[A[i]]++;
            arr[B[i]]++;
            for (int j = 0; j < n + 1; j++) {
                if (arr[j] == 2) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int start = grid[i][j];
                int temp = start;
                if (start != 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0 && !visited[nx][ny]) {
                                temp += grid[nx][ny];
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    public long countOperationsToEmptyArray(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
//        DoubleWeeklyComp103 doubleWeeklyComp103 = new DoubleWeeklyComp103();
//        int[][] grid = {{6, 1, 10}};
//        System.out.println(doubleWeeklyComp103.findMaxFish(grid));
    }


}
