package com.dengwn.code.leetcode.solution.t0.h1.d0;

import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-05-25
 **/
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (step % 2 == 1) {
                Collections.reverse(temp);
            }
            ans.add(temp);
            step++;
        }
        return ans;
    }
}
