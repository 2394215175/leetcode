package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-04-18
 **/
public class Solution1026 {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root.val, root.val, root);
    }

    public int dfs(int max, int min, TreeNode node) {
        if (node.left == null && node.right == null) {
            return max - min;
        }
        int ans = 0;
        if (node.left != null) {
            ans = Math.max(ans, dfs(Math.max(max, node.left.val), Math.min(min, node.left.val), node.left));
        }
        if (node.right != null) {
            ans = Math.max(ans, dfs(Math.max(max, node.right.val), Math.min(min, node.right.val), node.right));
        }
        return ans;
    }
}
