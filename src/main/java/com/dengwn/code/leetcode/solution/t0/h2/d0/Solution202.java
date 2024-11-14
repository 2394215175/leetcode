package com.dengwn.code.leetcode.solution.t0.h2.d0;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2022-12-29
 **/
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n)) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            set.add(n);
            int ans = 0;
            while (n > 0) {
                ans += (n % 10) * (n % 10);
                n /= 10;
            }
            n = ans;
        }
    }
}
