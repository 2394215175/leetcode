package com.dengwn.leetcode.solution.t0.h1.d1;


import com.dengwn.leetcode.solution.t0.h1.d1.help116.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-01-17
 **/
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
