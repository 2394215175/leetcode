package com.dengwn.code.leetcode.solution.t1.h4.d4;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 *
 * @author dengwenning
 * @since 2024/11/14
 **/
public class Solution1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int ans = root.val >= max ? 1 : 0;
        ans += dfs(root.left, Math.max(root.val, max));
        ans += dfs(root.right, Math.max(root.val, max));
        return ans;
    }

    public static void main(String[] args) {
        Solution1448 solution1448 = new Solution1448();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(solution1448.goodNodes(root));
    }
}
