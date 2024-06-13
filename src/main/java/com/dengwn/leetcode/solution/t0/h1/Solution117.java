package com.dengwn.leetcode.solution.t0.h1;

import com.dengwn.leetcode.solution.t0.h1.help116.Node;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-08
 **/
public class Solution117 {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution117 solution117 = new Solution117();
        Node node7 = new Node(7);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, null, node7, null);
        Node node1 = new Node(1, node2, node3, null);

        System.out.println(solution117.connect(node1));
    }
}
