package com.dengwn.code.leetcode.solution.t0.h6.d1;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-01-05
 **/
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
