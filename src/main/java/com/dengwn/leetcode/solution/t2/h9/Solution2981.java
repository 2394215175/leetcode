package com.dengwn.leetcode.solution.t2.h9;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/29
 **/
public class Solution2981 {
    public int maximumLength(String s) {
        int n = s.length();
        List<Integer>[] cnt = new List[26];
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = new ArrayList<>();
        }
        char prev = s.charAt(0);
        int prevCnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == prev) {
                prevCnt++;
            } else {
                cnt[prev - 'a'].add(prevCnt);
                prev = s.charAt(i);
                prevCnt = 1;
            }
        }
        cnt[prev - 'a'].add(prevCnt);
        int ans = -1;
        for (List<Integer> list : cnt) {
            if (list.isEmpty()) {
                continue;
            }
            list.sort(Collections.reverseOrder());
            list.add(0);
            list.add(0);
            ans = Math.max(ans, Math.max(list.get(0) - 2, Math.max(Math.min(list.get(0) - 1, list.get(1)), list.get(2))));

        }
        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        Solution2981 solution2981 = new Solution2981();
        System.out.println(solution2981.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
    }
}
