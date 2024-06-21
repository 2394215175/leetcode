package com.dengwn.leetcode.solution.t0.h8.d5;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-12-30
 */
public class Solution855 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(0);
        examRoom.leave(4);
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(0);
        System.out.print("null,");
        examRoom.leave(4);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(7);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(3);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(3);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(9);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(0);
        System.out.print("null,");
        examRoom.leave(8);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(0);
        System.out.print("null,");
        examRoom.leave(8);
        System.out.print("null,");
        System.out.print(examRoom.seat() + ",");
        System.out.print(examRoom.seat() + ",");
        examRoom.leave(2);
        System.out.print("null,");

    }
}

class ExamRoom {
    int N;
    TreeSet<Integer> students;

    public ExamRoom(int n) {
        N = n;
        students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if (!students.isEmpty()) {
            int dist = students.first();
            Integer pre = null;
            for (Integer s : students) {
                if (pre != null) {
                    int d = (s - pre) / 2;
                    if (d > dist) {
                        dist = d;
                        student = pre + d;
                    }
                }
                pre = s;
            }
            if (N - 1 - students.last() > dist){
                student = N - 1;
            }
        }

        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }
}
