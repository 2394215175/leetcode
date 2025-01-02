package com.dengwn.code.leetcode.solution.t0.h1.d1;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class Solution114 {
    List<TreeNode> nodes = new ArrayList<>();

    public void flatten(TreeNode root) {
        dfs(root);
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode pre = nodes.get(i - 1);
            TreeNode cur = nodes.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
