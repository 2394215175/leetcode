package com.dengwn.leetcode.solution.t0.h0;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2024-03-22
 **/
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1, null);
        ListNode right = new ListNode(-1, null);
        ListNode temp = right;
        ListNode ans = left;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = temp.next;
        return ans.next;
    }

    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        solution86.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
    }
}
