package com.dengwn.code.leetcode.solution.t0.h0.d2;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vir = new ListNode(0, head);
        ListNode ans = vir;
        ListNode temp = vir;
        while (true) {
            for (int i = 0; i < k; i++) {
                temp = temp.next;
                if (temp == null) {
                    return ans.next;
                }
            }

            ListNode next = vir.next;
            ListNode last = temp.next;
            temp.next = null;
            vir.next = reverse(next);
            while (vir.next != null) {
                vir = vir.next;
            }
            vir.next = last;
            temp = vir;
        }
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode reverse = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return reverse;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = solution25.reverseKGroup(head, 2);
        System.out.println(listNode);
    }
}
