package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;
import lombok.val;

/**
 * @author: dengwn
 * @date: 2023-03-02
 **/
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode ans7 = new ListNode(6);
        ListNode ans6 = new ListNode(5, ans7);
        ListNode ans5 = new ListNode(4, ans6);
        ListNode ans4 = new ListNode(3, ans5);
        ListNode ans3 = new ListNode(6, ans4);
        ListNode ans2 = new ListNode(2, ans3);
        ListNode ans1 = new ListNode(1, ans2);

        Solution203 solution203 = new Solution203();
        System.out.println(solution203.removeElements1(ans1, 6));

    }
}
