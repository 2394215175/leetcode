package com.dengwn.code.leetcode.solution.t0.h0.d2;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = swapPairs(head.next.next);
        second.next = head;
        return second;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode temp = new ListNode(0, head);
        ListNode temp2 = temp;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = temp.next.next;
        }
        return temp2.next;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(solution24.swapPairs1(head));
    }
}
