package com.dengwn.code.leetcode.solution.t0.h0.d7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-01-17
 **/
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        getCombine(n, k, 1, list, ans);
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
    }
}
