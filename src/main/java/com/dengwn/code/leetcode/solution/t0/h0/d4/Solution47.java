package com.dengwn.code.leetcode.solution.t0.h0.d4;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-17
 **/
public class Solution47 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.sort(nums);
        Deque<Integer> temp = new LinkedList<>();
        dfs(nums, temp, used, n);
        return ans;
    }

    public void dfs(int[] nums, Deque<Integer> temp, boolean[] used, int n) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            temp.addLast(nums[i]);
            used[i] = true;
            dfs(nums, temp, used, n);
            used[i] = false;
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = {1, 1, 2};
        System.out.println(solution47.permuteUnique(nums));
    }
}
