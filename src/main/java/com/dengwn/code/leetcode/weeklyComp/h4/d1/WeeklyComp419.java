package com.dengwn.code.leetcode.weeklyComp.h4.d1;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/10/17
 **/
public class WeeklyComp419 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k];
        return res;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> hs = new ArrayList<>();
        dfs(root, hs);
        if (k > hs.size()) {
            return -1;
        }
        Collections.sort(hs);
        return (1 << hs.get(hs.size() - k)) - 1;
    }

    public int dfs(TreeNode root, List<Integer> hs) {
        if (root == null) {
            // 叶子节点
            return 0;
        }
        int left = dfs(root.left, hs);
        int right = dfs(root.right, hs);
        if (left != right || left < 0) {
            return -1;
        }
        hs.add(left + 1);
        return left + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
