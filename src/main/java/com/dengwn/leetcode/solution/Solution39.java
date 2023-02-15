package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-09
 **/
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, target, list, ans, 0);
        return ans;
    }

    public void dfs(int[] candidates, int sum, int target, List<Integer> list, List<List<Integer>> ans, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];
            list.add(candidate);
            dfs(candidates, sum + candidate, target, list, ans, i);
            list.remove(list.size() - 1);
        }
    }
}
