package com.dengwn.code.leetcode.solution.t0.h1.d0;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution105 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, 0, n);
    }

    private TreeNode dfs(int[] preorder, int preL, int preR, int inL, int inR) {
        if (preL == preR) {
            return null;
        }
        int leftSize = map.get(preorder[preL]) - inL;
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, inL, inL + leftSize + 1);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, inL + leftSize + 1, inR);
        return new TreeNode(preorder[preL], left, right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution105 solution105 = new Solution105();
        TreeNode node = solution105.buildTree(preorder, inorder);
        System.out.println(node);

    }
}
