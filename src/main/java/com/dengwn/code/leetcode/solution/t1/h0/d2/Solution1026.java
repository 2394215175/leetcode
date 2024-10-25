package com.dengwn.code.leetcode.solution.t1.h0.d2;

import com.dengwn.code.leetcode.solution.TreeNode;

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

    int ans = 0;

    public void dfs1(int max, int min, TreeNode node) {
        if (node == null) {
            return;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        ans = Math.max(ans, max - min);
        dfs1(max, min, node.left);
        dfs1(max, min, node.right);
    }

    public int dfs2(int max, int min, TreeNode node) {
        if (node == null) {
            return max - min;
        }
        int ans = 0;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(ans, Math.max(dfs2(max, min, node.left), dfs2(max, min, node.right)));
    }
}
