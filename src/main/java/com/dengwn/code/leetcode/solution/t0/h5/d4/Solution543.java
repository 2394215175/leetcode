package com.dengwn.code.leetcode.solution.t0.h5.d4;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution543 {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
