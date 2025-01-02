package com.dengwn.code.leetcode.solution.t0.h1.d9;

import com.dengwn.code.leetcode.solution.TreeNode;
import com.dengwn.code.leetcode.solution.t0.h0.d2.Solution24;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/12/19
 **/
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<List<TreeNode>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(root));
        while (!queue.isEmpty()) {
            List<TreeNode> cur = queue.poll();
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < cur.size(); i++) {
                TreeNode node = cur.get(i);
                if (i == 0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
                if (node.left != null) {
                    next.add(node.left);
                }
            }
            if (!next.isEmpty()) {
                queue.add(next);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(solution199.rightSideView(root));
    }
}
