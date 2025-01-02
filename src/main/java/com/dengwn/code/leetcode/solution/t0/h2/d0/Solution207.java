package com.dengwn.code.leetcode.solution.t0.h2.d0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] inode = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            lists[prerequisite[0]].add(prerequisite[1]);
            inode[prerequisite[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inode[i] == 0) {
                queue.add(i);
            }
        }
        int vis = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            vis++;
            for (int next : lists[cur]) {
                if (--inode[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return vis == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(numCourses, prerequisites));

    }
}
