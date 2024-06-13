package com.dengwn.leetcode.solution.t0.h0.d9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-08
 **/
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(false, 0, nums, list, ans);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(false, cur + 1, nums, list, ans);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        list.add(nums[cur]);
        dfs(true, cur + 1, nums, list, ans);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        int[] nums = {1, 2, 2};
        System.out.println(solution90.subsetsWithDup(nums));
    }
}
