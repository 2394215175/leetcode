package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2022-12-27
 **/
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int cur = l1Val + l2Val + temp.val;
            carry = cur >= 10;
            temp.val = cur % 10;
            if (l1 != null || l2 != null || carry) {
                temp.next = new ListNode(carry ? 1 : 0);
                temp = temp.next;
            }
        }

        return ans;
    }


}
