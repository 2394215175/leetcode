package com.dengwn.code.leetcode.solution.t0.h0.d1;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2022-12-27
 **/
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0, head);
        ListNode slow = virtual;
        ListNode fast = head;
        while (n > 1 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtual.next;
    }

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1);
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.removeNthFromEnd(node1, 1).val);
    }
}

