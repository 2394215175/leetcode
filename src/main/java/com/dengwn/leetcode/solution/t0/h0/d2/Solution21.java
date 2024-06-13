package com.dengwn.leetcode.solution.t0.h0.d2;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-01-16
 **/
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode listNode = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                listNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                listNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            listNode = listNode.next;
        }

        if(list1 == null){
            listNode.next = list2;
        }else {
            listNode.next = list1;
        }
        return ans;
    }
}
