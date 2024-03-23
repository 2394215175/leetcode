package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2024-03-19
 **/
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head);

        ListNode pre = node;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode rightPart = rightNode.next;
        rightNode.next = null;

        ListNode leftNode = pre.next;

        ListNode reversed = reverseList(leftNode);

        pre.next = reversed;
        while (reversed.next != null){
            reversed = reversed.next;
        }
        reversed.next = rightPart;

        return node.next;
    }

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
        Solution92 solution92 = new Solution92();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution92.reverseBetween(node, 2, 4));
    }
}
