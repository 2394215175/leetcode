package com.dengwn.leetcode.solution.t1.h7.d3;

/**
 * @author dengwn
 * @date: 2022-12-25
 */
public class Solution1739 {
    public int minimumBoxes(int n) {
        int index = 1;
        int ans = 0;
        while (ans < n) {
            ans += index * (index + 1) / 2;
            index++;
        }
        if (ans == n) {
            return index * (index - 1) / 2;
        }

        int ceil = index - 1;
        int i = 0;
        int first = ceil * (ceil - 1) / 2;
        int start = ans - ceil * (ceil + 1) / 2;

        while (start < n) {
            i++;
            start += i;
        }

        return first + i;
    }

    public static void main(String[] args) {
        Solution1739 solution1739 = new Solution1739();
        System.out.println(solution1739.minimumBoxes(10));
    }
}
