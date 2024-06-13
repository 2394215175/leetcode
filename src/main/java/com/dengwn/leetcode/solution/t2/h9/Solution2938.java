package com.dengwn.leetcode.solution.t2.h9;

/**
 * @author dengwenning
 * @since 2024/6/6
 **/
public class Solution2938 {
    public long minimumSteps(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        long ans = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] == '0'){
                ans += i - k;
                k++;
            }
        }
        return ans;
    }

}
