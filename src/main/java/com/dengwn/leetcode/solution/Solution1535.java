package com.dengwn.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author dengwenning
 * @since 2024/5/21
 **/
public class Solution1535 {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) {
            Arrays.sort(arr);
            return arr[n - 1];
        }

        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int j : arr) {
            deque.addLast(j);
        }
        while (cnt < k) {
            Integer first = deque.pop();
            Integer second = deque.pop();
            if (first > second) {
                cnt++;
                deque.addFirst(first);
                deque.addLast(second);
            } else {
                deque.addFirst(second);
                deque.addLast(first);
                cnt = 1;
            }
        }
        return deque.peek();
    }

    public int getWinner1(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        int cnt = -1;
        for (int i = 0; i < n && cnt < k; i++) {
            if (arr[i] > max){
                cnt = 0;
                max = arr[i];
            }
            cnt++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1535 solution1535 = new Solution1535();
        System.out.println(solution1535.getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
    }
}
