package com.dengwn.code.leetcode.solution.t0.h1.d0;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
