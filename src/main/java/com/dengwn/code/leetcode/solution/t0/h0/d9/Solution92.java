package com.dengwn.code.leetcode.solution.t0.h0.d9;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2024-03-19
 **/
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ans = new ListNode(0, head);
        ListNode temp = ans;
        for (int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }
        ListNode leftNode = temp;
        temp = temp.next;
        for (int i = left; i <= right; i++) {
            temp = temp.next;
        }
        ListNode rightNode = null;
        if (temp != null) {
            rightNode = temp.next;
            temp.next = null;
        }

        ListNode reversedNode = reverse(leftNode.next);

        leftNode.next = reversedNode;
        if (reversedNode != null) {
            while (reversedNode.next != null) {
                reversedNode = reversedNode.next;
            }
            reversedNode.next = rightNode;
        }

        return ans.next;
    }

    public ListNode reverse(ListNode head) {
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
        Solution92 solution92 = new Solution92();
        ListNode node = new ListNode(3, new ListNode(5));
        System.out.println(solution92.reverseBetween(node, 1, 2));
    }
}
