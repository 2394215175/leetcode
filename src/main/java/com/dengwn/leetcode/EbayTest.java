package com.dengwn.leetcode;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-07-03
 **/
public class EbayTest {
    public static void main(String[] args) {
        int[][] boards = {{1, 4}, {2, 3}, {3, 4}};
        Graph graph = new Graph(boards, 4);
//        Graph resver = resver(graph);
//        List<Integer>[] lists = resver.lists;
//        for (int i = 0; i < lists.length; i++) {
//            for (Integer j : lists[i]) {
//                System.out.println(i + "->" + j);
//            }
//        }
        System.out.println(bfs(graph));

    }

    public static Graph reverse(Graph graph) {
        List<Integer>[] lists = graph.lists;
        int n = lists.length;
        int[][] boards = new int[n * n][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (Integer j : lists[i]) {
                boards[index++] = new int[]{j, i};
            }
        }
        int[][] nboards = new int[index][2];
        System.arraycopy(boards, 0, nboards, 0, index);
        return new Graph(nboards, n - 1);
    }

    public static List<Integer> bfs(Graph graph) {
        Graph reverse = reverse(graph);
        List<Integer> res = new ArrayList<>();
        List<Integer>[] graphLists = graph.lists;
        List<Integer>[] reverseLists = reverse.lists;
        int n = reverseLists.length;

        for (int i = 1; i < n; i++) {
            if (graphLists[i].isEmpty()) {
                res.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>(res);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                List<Integer> next = reverseLists[cur];
                for (Integer j : next) {
                    queue.add(j);
                    res.add(j);
                }
            }
        }

        return res;
    }
}

class Graph {
    List<Integer>[] lists;

    public Graph(int[][] boards, int n) {
        lists = new List[n + 1];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] board : boards) {
            lists[board[0]].add(board[1]);
        }
    }
}
