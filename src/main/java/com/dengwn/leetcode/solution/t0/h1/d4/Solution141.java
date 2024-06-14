package com.dengwn.leetcode.solution.t0.h1.d4;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-02-28
 **/
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
