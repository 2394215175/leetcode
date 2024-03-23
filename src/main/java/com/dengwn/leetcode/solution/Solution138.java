package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help138.Node;

import java.util.HashMap;

/**
 * @author: dengwn
 * @date: 2024-03-19
 **/
public class Solution138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> dict = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            dict.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            dict.get(cur).next = dict.get(cur.next);
            dict.get(cur).random = dict.get(cur.random);
            cur = cur.next;
        }

        return dict.get(head);

    }

    public static void main(String[] args) {
        Node node4 = new Node(1, null);
        Node node3 = new Node(10, node4);
        Node node2 = new Node(11, node3);
        Node node1 = new Node(13, node2);
        Node head = new Node(7, node1);

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        Solution138 solution138 = new Solution138();
        System.out.println(solution138.copyRandomList(head));

    }
}
