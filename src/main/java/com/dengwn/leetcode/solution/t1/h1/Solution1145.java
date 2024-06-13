package com.dengwn.leetcode.solution.t1.h1;

import com.dengwn.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-02-03
 **/
public class Solution1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode temp = dfs(root, x);
        int left = dfs(temp.left);
        int right = dfs(temp.right);

        return left > n / 2 || right > n / 2 || (left + right) < n / 2;
    }

    public TreeNode dfs(TreeNode root, int x) {
        if (root == null || root.val == x) {
            return root;
        }
        TreeNode left = dfs(root.left, x);
        return left != null ? left : dfs(root.right, x);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int n = 1;
        if (root.left != null) {
            n += dfs(root.left);
        }
        if (root.right != null) {
            n += dfs(root.right);
        }
        return n;
    }

    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5, treeNode10, treeNode11);
        TreeNode treeNode4 = new TreeNode(4, treeNode8, treeNode9);

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);

        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        Solution1145 solution1145 = new Solution1145();
        System.out.println(solution1145.dfs(treeNode1));

    }
}
