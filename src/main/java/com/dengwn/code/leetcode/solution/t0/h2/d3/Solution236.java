package com.dengwn.code.leetcode.solution.t0.h2.d3;

import com.dengwn.code.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-04-24
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
