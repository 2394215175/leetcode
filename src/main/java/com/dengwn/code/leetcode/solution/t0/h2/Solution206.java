package com.dengwn.code.leetcode.solution.t0.h2;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        System.out.println(solution206.reverseList(listNode1).val);
    }
}
