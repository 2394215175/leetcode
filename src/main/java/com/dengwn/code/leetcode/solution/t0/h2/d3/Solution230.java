package com.dengwn.code.leetcode.solution.t0.h2.d3;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution230 {
    int K;

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        return dfs(root);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = dfs(node.left);
        if (left != -1) {
            return left;
        }
        K--;
        if (K == 0) {
            return node.val;
        }
        return dfs(node.right);
    }
}
