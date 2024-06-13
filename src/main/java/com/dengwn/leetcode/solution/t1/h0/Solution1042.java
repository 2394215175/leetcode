package com.dengwn.leetcode.solution.t1.h0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengwn
 * @date: 2023-04-15
 */
public class Solution1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            lists[path[0] - 1].add(path[1] - 1);
            lists[path[1] - 1].add(path[0] - 1);
        }

        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            boolean[] used = new boolean[4];
            List<Integer> list = lists[i];
            for (Integer j : list) {
                if (ans[j] != 0) {
                    used[ans[j] - 1] = true;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (!used[j]) {
                    ans[i] = j + 1;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1042 solution1042 = new Solution1042();
        int n = n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(solution1042.gardenNoAdj(n, paths)));
    }
}
