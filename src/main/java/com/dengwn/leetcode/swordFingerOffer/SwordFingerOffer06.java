package com.dengwn.leetcode.swordFingerOffer;

import com.dengwn.leetcode.solution.t0.h8.d7.help876.ListNode;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-05-09
 **/
public class SwordFingerOffer06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int n = 0;
        while (head != null) {
            stack.push(head);
            head = head.next;
            n++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;

    }
}
