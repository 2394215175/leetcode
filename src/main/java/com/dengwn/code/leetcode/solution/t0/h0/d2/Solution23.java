package com.dengwn.code.leetcode.solution.t0.h0.d2;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/18
 **/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            node = node.next;
            temp = temp.next;
            if (node != null) {
                pq.add(node);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.mergeKLists(lists));
    }
}
