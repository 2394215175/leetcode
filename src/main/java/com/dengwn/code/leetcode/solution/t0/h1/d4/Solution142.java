package com.dengwn.code.leetcode.solution.t0.h1.d4;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
