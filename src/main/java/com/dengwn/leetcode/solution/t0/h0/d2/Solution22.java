package com.dengwn.leetcode.solution.t0.h0.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-09
 **/
public class Solution22 {
    List<String> res = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    String[] strings = {"(", ")"};

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

    public void dfs(int left, int right, int n) {
        if (left > n || right > n || right > left) {
            return;
        }
        if (left == n && right == n) {
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            stringBuilder.append(strings[i]);
            if (i == 0) {
                dfs(left + 1, right, n);
            } else {
                dfs(left, right + 1, n);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(8));
    }
}
