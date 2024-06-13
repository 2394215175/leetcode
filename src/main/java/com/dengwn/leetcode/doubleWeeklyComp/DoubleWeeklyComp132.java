package com.dengwn.leetcode.doubleWeeklyComp;

import java.util.ArrayDeque;

/**
 * @author dengwenning
 * @since 2024/6/11
 **/
public class DoubleWeeklyComp132 {

    public String clearDigits(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                array[i] = 'A';
                int pre = i - 1;
                while (pre >= 0) {
                    if (array[pre] >= 'a' && array[pre] <= 'z') {
                        array[pre] = 'A';
                        break;
                    }
                    pre--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : array) {
            if (c != 'A') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        if (k >= n) {
            int maxIndex = 0;
            int max = skills[0];
            for (int i = 1; i < n; i++) {
                if (skills[i] > max) {
                    max = skills[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arrayDeque.add(new int[]{skills[i], i});
        }
        int time = 0;
        while (time < k) {
            int[] first = arrayDeque.poll();
            int[] second = arrayDeque.poll();
            if (first[0] > second[0]) {
                arrayDeque.addFirst(first);
                arrayDeque.addLast(second);
                time++;
            } else {
                arrayDeque.addFirst(second);
                arrayDeque.addLast(first);
                time = 1;
            }
        }
        return arrayDeque.peek()[1];
    }

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        // dp[i][j]=max(dp[j][k−1](a[i]!=a[j])，dp[j][k](a[i]=a[j]))。
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            for (int kk = 0; kk <= k; kk++) {
                for (int j = 1; j < i; j++) {
                    if (nums[i - 1] == nums[j - 1]) {
                        dp[i][kk] = Math.max(dp[i][kk], dp[j][kk] + 1);
                    } else {
                        if (kk - 1 >= 0) {
                            dp[i][kk] = Math.max(dp[i][kk], dp[j][kk - 1] + 1);
                        }
                    }
                    ans = Math.max(ans, dp[i][kk]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp132 doubleWeeklyComp132 = new DoubleWeeklyComp132();

//        System.out.println(doubleWeeklyComp132.findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));

        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        System.out.println(doubleWeeklyComp132.maximumLength(nums, k));


    }
}
