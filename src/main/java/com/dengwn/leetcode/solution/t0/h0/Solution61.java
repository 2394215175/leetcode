package com.dengwn.leetcode.solution.t0.h0;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2024-03-22
 **/
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = null;
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            tail = temp;
            temp = temp.next;
        }
        tail.next = head;

        k %= n;
        temp = head;
        for (int i = 0; i < n - k - 1; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        System.out.println(solution61.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3))), 1));
    }
}
