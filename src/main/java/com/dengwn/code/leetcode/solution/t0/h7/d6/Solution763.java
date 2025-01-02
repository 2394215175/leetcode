package com.dengwn.code.leetcode.solution.t0.h7.d6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/25
 **/
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt[array[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, cnt[array[i] - 'a']);
            if (i == last) {
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution763 solution763 = new Solution763();
        System.out.println(solution763.partitionLabels("vhaagbqkaq"));
    }
}
