package com.dengwn.code.leetcode.weeklyComp.h4.d1;

import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author dengwenning
 * @since 2024/9/22
 **/
public class WeeklyComp416 {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> bannedWordsSet = new HashSet<>();
        Collections.addAll(bannedWordsSet, bannedWords);
        int a = 0;
        for (String s : message) {
            if (bannedWordsSet.contains(s)) {
                a++;
            }
        }
        return a >= 2;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int max = 0;
        for (int workerTime : workerTimes) {
            max = Math.max(max, workerTime);
        }
        long left = 0;
        long right = (long) mountainHeight * (mountainHeight + 1) * max / 2;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(long time, int mountainHeight, int[] workerTimes) {
        int sum = 0;
        for (int workerTime : workerTimes) {
            double x = time * 1.0 / workerTime;
            int v = (int) Math.floor((Math.sqrt(1 + 8 * x) - 1) / 2);
            sum += v;
        }
        return sum >= mountainHeight;
    }

    public long validSubstringCount(String word1, String word2) {
        int[] cnt2 = new int[26];
        for (char c : word2.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int[] cnt1 = new int[26];
        char[] array = word1.toCharArray();
        int n = array.length;
        int left = 0;
        int right = 0;
        long ans = 0;
        while (right < n) {
            if (isPrefix(cnt1, cnt2)) {
                cnt1[array[left] - 'a']--;
                left++;
                ans += n - right + 1;
            } else {
                cnt1[array[right] - 'a']++;
                right++;
            }
        }
        while (left < n) {
            if (isPrefix(cnt1, cnt2)) {
                ans++;
                cnt1[array[left] - 'a']--;
                left++;
            } else {
                break;
            }
        }

        return ans;
    }

    public boolean isPrefix(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] < cnt2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WeeklyComp416 weeklyComp416 = new WeeklyComp416();

//        int mountainHeight = 4;
//        int[] workerTimes = {2, 1, 1};
//        System.out.println(weeklyComp416.minNumberOfSeconds(mountainHeight, workerTimes));

        String word1 = "ddccdddccdddccccdddccdcdcd";
        String word2 = "ddc";
        System.out.println(weeklyComp416.validSubstringCount(word1, word2));
    }
}
