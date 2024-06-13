package com.dengwn.leetcode.solution.t0.h0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-09
 **/
public class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }


    public void dfs(int[] candidates, int target, int n) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = n; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i != n && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(candidates, target));
    }
}
