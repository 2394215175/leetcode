package com.dengwn.code.leetcode.solution.t0.h0.d5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/2
 **/
public class Solution51 {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(0, n, new int[n]);
        return ans;
    }

    public void dfs(int n, int max, int[] arr) {
        if (n == max) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == arr[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
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

    public static void main(String[] args) {
        Solution51 solution52 = new Solution51();
        System.out.println(solution52.solveNQueens(4));
    }

}
