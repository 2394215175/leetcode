package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;

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
