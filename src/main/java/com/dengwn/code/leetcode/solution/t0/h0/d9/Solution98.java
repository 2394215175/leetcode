package com.dengwn.code.leetcode.solution.t0.h0.d9;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        int x = node.val;
        return left < x && x < right && isValid(node.left, left, x) && isValid(node.right, x, right);
    }
}
