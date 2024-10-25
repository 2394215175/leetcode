package com.dengwn.code.leetcode.solution.t1.h6;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-01-30
 **/
public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp3 = list1;
        while (index <= b) {
            temp1 = temp1.next;
            index++;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        temp2.next = temp1;

        index = 0;
        while (index < a - 1) {
            temp3 = temp3.next;
            index++;
        }
        temp3.next = list2;
        return list1;
    }

    public static void main(String[] args) {

        ListNode list5 = new ListNode(5);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(3, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(1, list2);
        ListNode list0 = new ListNode(0, list1);

        ListNode list1000002 = new ListNode(1000002);
        ListNode list1000001 = new ListNode(1000001, list1000002);
        ListNode list1000000 = new ListNode(1000000, list1000001);
        Solution1669 solution1669 = new Solution1669();
        System.out.println(solution1669.mergeInBetween(list0, 3, 4, list1000000));
    }
}


