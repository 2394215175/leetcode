package com.dengwn.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.misc.Queue;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengwn
 * @date: 2024-03-11
 **/
public class Test {
    public static void main(String[] args) {
        Node node1 = new Node(2, new Node(4, new Node(5, null)));
        Node node2 = new Node(5, new Node(6, new Node(4, null)));

        Node node = add(node1, node2);
        System.out.println("-------------");
    }

    /**
     * 给两个链表, 表示两个数, 链表的每位数据都是按照逆序进行存储的, 并且每个节点只能够存储一位数字, 进行两数相加, 以相同的形式返回一个表示和的链表
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public static Node add(Node node1, Node node2) {
        int flag = 0;

        Node ans = new Node(0, null);
        Node res = ans;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + flag;
            Node node = new Node(sum % 10, null);
            flag = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
            ans.next = node;
            ans = ans.next;
        }

        if (node1 == null) {
            while (node2 != null){
                int sum = node2.val + flag;
                Node node = new Node(sum % 10, null);
                flag = sum / 10;
                node2 = node2.next;
                ans.next = node;
                ans = ans.next;
            }
        }
        if (node2 == null) {
            while (node1 != null){
                int sum = node1.val + flag;
                Node node = new Node(sum % 10, null);
                flag = sum / 10;
                node = node1.next;
                ans.next = node;
                ans = ans.next;
            }
        }

        if (flag == 1){

        }

        return res.next;
    }


}

@AllArgsConstructor
@Data
class Node {
    int val;
    Node next;
}