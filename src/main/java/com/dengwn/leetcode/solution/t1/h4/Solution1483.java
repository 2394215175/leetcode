package com.dengwn.leetcode.solution.t1.h4;

/**
 * @author: dengwn
 * @date: 2023-06-12
 **/
public class Solution1483 {
    public static void main(String[] args) {
//        int n = 5;
//        int[] parent = {-1, 0, 0, 0, 3};

        int n = 7;
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        TreeAncestor treeAncestor = new TreeAncestor(n, parent);

//        System.out.println(treeAncestor.getKthAncestor(1, 5));
//        System.out.println(treeAncestor.getKthAncestor(3, 2));
//        System.out.println(treeAncestor.getKthAncestor(0, 1));
//        System.out.println(treeAncestor.getKthAncestor(3, 1));
//        System.out.println(treeAncestor.getKthAncestor(3, 5));

        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));

    }
}

class TreeAncestor {
    int[][] p;

    public TreeAncestor(int n, int[] parent) {
        int m = Integer.toBinaryString(n).length();
        p = new int[n][m];
        for (int i = 0; i < n; i++) {
            p[i][0] = parent[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[j][i] = p[j][i - 1] < 0 ? -1 : p[p[j][i - 1]][i - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        String n = Integer.toBinaryString(k);
        int l = n.length();
        for (int i = 0; i < l; i++) {
            if (n.charAt(i) == '1') {
                node = p[node][l - i - 1];
                if (node < 0) {
                    break;
                }
            }
        }
        return node;
    }
}
