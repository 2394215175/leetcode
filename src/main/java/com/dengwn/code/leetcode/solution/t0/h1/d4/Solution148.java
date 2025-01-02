package com.dengwn.code.leetcode.solution.t0.h1.d4;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = node1, temp2 = node2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1))));
        Solution148 solution148 = new Solution148();
        ListNode listNode = solution148.sortList(head);
        System.out.println("----");
    }
}
