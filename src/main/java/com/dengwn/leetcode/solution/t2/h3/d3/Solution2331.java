package com.dengwn.leetcode.solution.t2.h3.d3;

import com.dengwn.leetcode.solution.TreeNode;

/**
 * @author: dengwn
 * @date: 2023-02-06
 **/
public class Solution2331 {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root) == 1;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int val = root.val;
        if (val == 1 || val == 0) {
            return val;
        }
        if (val == 2) {
            return dfs(root.left) == 1 || dfs(root.right) == 1 ? 1 : 0;
        }
        if (val == 3) {
            return dfs(root.left) == 1 && dfs(root.right) == 1 ? 1 : 0;
        }
        return -1;
    }
}
