package com.dengwn.code.leetcode.solution.t3.h3.d8;

/**
 *
 * @author dengwenning
 * @since 2024/12/17
 **/
public class Solution3386 {
    public int buttonWithLongestTime(int[][] events) {
        int preTime = 0;
        int maxTime = 0;
        int ans = 0;
        for (int[] event : events) {
            int index = event[0];
            int time = event[1];
            if ((time - preTime > maxTime) || (time - preTime == maxTime && ans > index)) {
                ans = index;
                maxTime = time - preTime;
            }
            preTime = time;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = {{10, 5}, {1, 7}};
        Solution3386 solution3386 = new Solution3386();
        System.out.println(solution3386.buttonWithLongestTime(events));

    }
}
