package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/9/29
 **/
public class WeeklyComp417 {

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while (sb.length() < k) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                sb1.append((c == 'z') ? 'a' : (char) (c + 1));
            }
            sb.append(sb1);
        }
        return sb.charAt(k - 1);
    }

    public long countOfSubstrings(String word, int k) {
        return calc(word, k + 1) - calc(word, k);
    }

    public long calc(String word, int k) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int n = word.length();
        int[] cnt = new int[6];
        int ans = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            cnt[map.getOrDefault(c, 5)]++;
            if (cnt[5] >= k && check(cnt)) {
                ans++;
            }
        }
        return 0;
    }

    public boolean check(int[] nums) {
        for (int i = 0; i < 5; i++) {
            if (nums[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public char kthCharacter(long k, int[] operations) {
        if (k == 1) {
            return 'a';
        }

        // 计算哪次操作后，字符串长度至少为 K
        int lim;
        long len = 1;
        for (lim = 0; lim < operations.length; lim++) {
            len *= 2;
            if (len >= k) {
                break;
            }
        }

        // 倒推答案
        int bias = 0;
        for (int i = lim; i >= 0; i--) {
            if (k > len / 2) {
                // K 在字符串后半，找到它在前半的对应位置
                bias += operations[i];
                k -= len / 2;
            }
            len /= 2;
        }
        return (char) (bias % 26 + 'a');

    }


    public static void main(String[] args) {
        WeeklyComp417 weeklyComp417 = new WeeklyComp417();

//        System.out.println(weeklyComp417.kthCharacter(5));

        System.out.println(weeklyComp417.countOfSubstrings("iqeaouqi", 2));

//        System.out.println(weeklyComp417.kthCharacter(4, new int[]{0, 0, 1}));
    }
}
