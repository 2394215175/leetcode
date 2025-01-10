package com.dengwn.code.leetcode.solution.t1.h3.d6;

import com.dengwn.code.leetcode.solution.TreeNode;
import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 *
 * @author dengwenning
 * @since 2025/1/7
 **/
public class Solution1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(2, new ListNode(1)));
        TreeNode root = new TreeNode(2, null, new TreeNode(2, null, new TreeNode(2, null, new TreeNode(1))));
        Solution1367 solution1367 = new Solution1367();
        System.out.println(solution1367.isSubPath(head, root));
    }

}
