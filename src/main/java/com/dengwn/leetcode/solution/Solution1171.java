package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-06-12
 **/
public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            map.put(prefix, node);
        }

        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = map.get(prefix).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution1171 solution1171 = new Solution1171();

        ListNode head5 = new ListNode(1);
        ListNode head4 = new ListNode(3, head5);
        ListNode head3 = new ListNode(-3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);

        System.out.println(solution1171.removeZeroSumSublists(head1));
    }


}
