package com.dengwn.code.leetcode.weeklyComp.h3.d8;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/13
 **/
public class WeeklyComp381 {

    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        Arrays.sort(cnt);
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] == 0) {
                break;
            }
            ans += (25 - i + 8) / 8;
        }
        return ans;
    }



    public static void main(String[] args) {
        WeeklyComp381 weeklyComp381 = new WeeklyComp381();

    }
}
