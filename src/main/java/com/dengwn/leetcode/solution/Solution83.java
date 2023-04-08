package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help876.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-03-02
 **/
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(10000, head);
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.val);
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode ans5 = new ListNode(3);
        ListNode ans4 = new ListNode(3, ans5);
        ListNode ans3 = new ListNode(2, ans4);
        ListNode ans2 = new ListNode(1, ans3);
        ListNode ans1 = new ListNode(1, ans2);

        Solution83 solution83 = new Solution83();
        System.out.println(solution83.deleteDuplicates(ans1));

    }
}
