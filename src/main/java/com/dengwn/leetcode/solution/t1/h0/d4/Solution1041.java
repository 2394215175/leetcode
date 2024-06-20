package com.dengwn.leetcode.solution.t1.h0.d4;

/**
 * @author: dengwn
 * @date: 2023-04-11
 **/
public class Solution1041 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public boolean isRobotBounded(String instructions) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            s.append(instructions);
        }
        char[] chars = s.toString().toCharArray();
        int direction = 0;
        int nx = 0;
        int ny = 0;
        for (char c : chars) {
            if (c == 'G') {
                nx = nx + dx[direction];
                ny = ny + dy[direction];
            } else if (c == 'L') {
                direction -= 1;
                if (direction < 0) {
                    direction += 4;
                }
            } else {
                direction += 1;
                if (direction > 3) {
                    direction -= 4;
                }
            }
        }
        return nx == 0 && ny == 0;
    }

    public static void main(String[] args) {
        Solution1041 solution1041 = new Solution1041();
        System.out.println(solution1041.isRobotBounded("GLGLGGLGL"));
    }
}
