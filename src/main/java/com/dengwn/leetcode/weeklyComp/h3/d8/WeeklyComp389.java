package com.dengwn.leetcode.weeklyComp.h3.d8;

import java.util.Arrays;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/6/14
 **/
public class WeeklyComp389 {

    public boolean isSubstringPresent(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        for (int i = 1; i < n; i++) {
            sb.append(array[i]);
            if (s.contains(sb.reverse().toString())) {
                return true;
            }
            sb.delete(1, 2);
        }
        return false;
    }

    public long countSubstrings(String s, char c) {
        char[] array = s.toCharArray();
        long cnt = 0;
        for (char c1 : array) {
            cnt += (c1 == c) ? 1 : 0;
        }
        return cnt * (cnt + 1) / 2;
    }

    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        char[] array = word.toCharArray();
        for (char c : array) {
            cnt[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        Arrays.sort(cnt);
        int pre = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            // 当前值保留
            int min = cnt[i];
            int cons = 0;
            for (int j = i + 1; j < 26; j++) {
                cons += Math.max(0, cnt[j] - min - k);
            }
            ans = Math.min(ans, pre + cons);
            pre += cnt[i];
        }
        return ans;
    }

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        return 0;
    }

    public static void main(String[] args) {
        WeeklyComp389 weeklyComp389 = new WeeklyComp389();

//        System.out.println(weeklyComp389.isSubstringPresent("goxo"));

        System.out.println(weeklyComp389.minimumDeletions("zzfzzzzppfp", 1));
    }
}
