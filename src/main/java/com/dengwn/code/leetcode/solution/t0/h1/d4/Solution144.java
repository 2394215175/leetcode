package com.dengwn.code.leetcode.solution.t0.h1.d4;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/23
 **/
public class Solution144 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
