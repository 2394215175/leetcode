package com.dengwn.leetcode.solution.t1.h1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-05-30
 **/
public class Solution1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>();
        for (int i : to_delete) {
            del.add(i);
        }
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, true, del, ans);
        return ans;
    }

    public TreeNode dfs(TreeNode root, boolean isRoot, Set<Integer> del, List<TreeNode> ans) {
        if (root == null) {
            return null;
        }
        boolean isDel = del.contains(root.val);
        if (isDel) {
            return null;
        }
        root.left = dfs(root.left, isDel, del, ans);
        root.right = dfs(root.right, isDel, del, ans);
        if (isRoot) {
            ans.add(root);
        }
        return root;
    }
}
