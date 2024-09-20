package com.dengwn.leetcode.solution.t2.h1.d8;

/**
 *
 * @author dengwenning
 * @since 2024/9/9
 **/
public class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = head;
        ListNode ans = head;
        while (dummyHead != null) {
            if (dummyHead.val == 0) {
                // 开始
                int val = dummyHead.val;
                while (dummyHead.next != null && dummyHead.next.val != 0) {
                    val += dummyHead.next.val;
                    dummyHead = dummyHead.next;
                }
                if (val != 0) {
                    head.next = new ListNode(val);
                }
                head = head.next;
                dummyHead = dummyHead.next;
            }
        }
        return ans.next;
    }

    public ListNode mergeNodes1(ListNode head) {
        ListNode tail = head;
        for (ListNode cur = head.next; cur.next != null; cur = cur.next) {
            if (cur.val != 0) {
                tail.val += cur.val;
            } else {
                tail = tail.next;
                tail.val = 0;
            }
        }
        tail.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));

//        ListNode head = new ListNode(0);
        Solution2181 solution = new Solution2181();
        ListNode result = solution.mergeNodes1(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
