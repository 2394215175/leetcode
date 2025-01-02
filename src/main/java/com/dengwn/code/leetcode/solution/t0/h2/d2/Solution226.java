package com.dengwn.code.leetcode.solution.t0.h2.d2;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        reverse(left);
        reverse(right);
        root.left = right;
        root.right = left;
    }
}
