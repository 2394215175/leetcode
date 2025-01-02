package com.dengwn.code.leetcode.solution.t0.h4.d3;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution437 {
    Map<Long, Integer> prefix = new HashMap<>();
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        prefix.put(0L, 1);
        dfs(root, 0, targetSum);
        return ans;
    }

    public void dfs(TreeNode node, long cur, int targetSum) {
        if (node == null) {
            return;
        }
        cur += node.val;
        ans += prefix.getOrDefault(cur - targetSum, 0);
        prefix.merge(cur, 1, Integer::sum);
        dfs(node.left, cur, targetSum);
        dfs(node.right, cur, targetSum);
        prefix.merge(cur, -1, Integer::sum);
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(solution437.pathSum(root, 8));
    }
}
