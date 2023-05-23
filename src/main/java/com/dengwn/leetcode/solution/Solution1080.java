package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-05-22
 **/
public class Solution1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit, 0);
    }

    public TreeNode dfs(TreeNode root, int limit, int sum) {
        if (root == null) {
            return null;
        }
        // 叶子节点 也可以写成 root.left == root.right
        if (root.left == null && root.right == null) {
            // 结果小于limit，删除
            if (sum + root.val < limit) {
                return null;
            } else {
                return root;
            }
        }
        sum += root.val;
        if (root.left != null) {
            root.left = dfs(root.left, limit, sum);
        }
        if (root.right != null) {
            root.right = dfs(root.right, limit, sum);
        }
        // 如果两个子节点都被删除了，自己也删除
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);

        TreeNode root1 = new TreeNode(10, root2, root3);

        Solution1080 solution1080 = new Solution1080();
        System.out.println(solution1080.sufficientSubset(root1, 21));
    }
}
