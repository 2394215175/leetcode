package com.dengwn.code.leetcode.solution.t0.h0.d9;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/18
 **/
public class Solution94 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution94 solution = new Solution94();
        System.out.println(solution.inorderTraversal(root));
    }
}
