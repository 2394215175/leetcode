package com.dengwn.code.leetcode.solution.t2.h3.d8;


import com.dengwn.code.leetcode.solution.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dengwenning
 * @since 2024/4/24
 **/
public class Solution2385 {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> nodeMap = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode startNode = null;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int k = nodes.size();
            for (int i = k; i > 0; i--) {
                TreeNode node = nodes.poll();
                if (node.val == start){
                    startNode = node;
                }
                if (node.left != null){
                    nodes.add(node.left);
                    nodeMap.put(node.left, node);
                }
                if (node.right != null){
                    nodes.add(node.right);
                    nodeMap.put(node.right, node);
                }
            }
        }

        nodes.add(startNode);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        int ans = 0;
        while (!nodes.isEmpty()){
            int k = nodes.size();
            for (int i = k; i > 0; i--) {
                TreeNode node = nodes.poll();
                TreeNode left = node.left;
                if (left != null && !visited.contains(left.val)){
                    nodes.add(left);
                    visited.add(left.val);
                }
                TreeNode right = node.right;
                if (right != null && !visited.contains(right.val)){
                    nodes.add(right);
                    visited.add(right.val);
                }
                TreeNode parent = nodeMap.get(node);
                if (parent != null && !visited.contains(parent.val)){
                    nodes.add(parent);
                    visited.add(parent.val);
                }
            }
            ans++;
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2, new TreeNode(5, null,null),null);

        Solution2385 solution2385 = new Solution2385();
        System.out.println(solution2385.amountOfTime(node, 5));
    }
}
