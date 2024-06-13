package com.dengwn.leetcode.solution.t0.h0;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-01-30
 **/
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(101, head);
        head = temp;
        while (temp.next != null && temp.next.next != null) {
            ListNode next = temp.next;
            if (next.val == next.next.val) {
                int value = next.val;
                while (next != null && next.val == value) {
                    next = next.next;
                }
                temp.next = next;
            }else {
                temp = temp.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(1);
        ListNode listNode41 = new ListNode(1, listNode5);

        Solution82 solution82 = new Solution82();
        System.out.println(solution82.deleteDuplicates(listNode41));
    }
}
