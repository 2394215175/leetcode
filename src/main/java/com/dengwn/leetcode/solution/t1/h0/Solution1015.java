package com.dengwn.leetcode.solution.t1.h0;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-05-10
 **/
public class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        long n = 1;
        int ans = 1;
        Set<Long> mods = new HashSet<>();
        long mod = n % k;
        while (mod != 0) {
            if (!mods.add(mod)) {
                return -1;
            }
            mod = (mod * 10 + 1) % k;
        }
        return ans;
    }


}
