package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-11-16
 **/
public class Solution52 {
    /**
     * 摆放方案的个数
     */
    int count = 0;

    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public void dfs(int n, int max, int[] arr) {
        if (n == max) {
            count++;
            return;
        }
        // 对每个皇后，都依次去尝试摆放在每一列
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            // 判断这个皇后摆放位置是否冲突
            if (isValid(n, arr)) {
                // 如果当前位置不冲突，继续递归，摆放下一个皇后
                dfs(n + 1, max, arr);
            }
            // 如果发生冲突，进入下一轮循环，尝试摆放在下一列
        }
    }

    public boolean isValid(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            // 判断是否在同一列，或一条对角线上
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }


    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }


}
