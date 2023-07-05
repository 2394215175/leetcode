package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-06-30
 **/
public class Solution1156 {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        char[] chars = text.toCharArray();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            cnt[chars[i] - 'a']++;
        }

        int i = 0;
        int j = 1;
        int ans = 1;
        while (j < n) {
            if (chars[j] != chars[i]) {
                // 判断能不能换
                int len = 0;
                if (cnt[chars[i] - 'a'] > j - i) {
                    // 能换，判断换后还能走多远
                    int k = j + 1;
                    while (k < n && chars[k] == chars[i]) {
                        k++;
                    }
                    len = k - i;
                    if (len > cnt[chars[i] - 'a']) {
                        len--;
                    }
                } else {
                    // 不能换
                    len = j - i;
                }
                if (len > ans) {
                    ans = len;
                }
                i = j;
            }
            j++;
        }

        int len = cnt[chars[i] - 'a'] > j - i ? j + 1 - i : j - i;
        if (len > ans) {
            ans = len;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1156 solution1156 = new Solution1156();
        System.out.println(solution1156.maxRepOpt1("acbaaa"));
    }
}
