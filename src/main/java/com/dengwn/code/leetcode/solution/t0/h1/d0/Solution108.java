package com.dengwn.code.leetcode.solution.t0.h1.d0;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = (left + right) >> 1;
        return new TreeNode(nums[mid], dfs(nums, left, mid), dfs(nums, mid + 1, right));
    }

}
