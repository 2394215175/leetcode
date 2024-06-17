package com.dengwn.leetcode.solution.t0.h5.d7;

import com.dengwn.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-02-03
 **/
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return equals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return equals(node1.left, node2.left) && equals(node1.right, node2.right);
    }
}
