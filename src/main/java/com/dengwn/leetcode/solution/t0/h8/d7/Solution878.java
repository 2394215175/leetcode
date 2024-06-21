package com.dengwn.leetcode.solution.t0.h8.d7;

/**
 * @author: dengwn
 * @date: 2022-11-22
 **/
public class Solution878 {
    public int nthMagicalNumber(int n, int a, int b) {
        int gcm = gcm(a, b);

        int na = a / gcm;
        int nb = b / gcm;
        int length = (na + nb - 1);
        int lcm = a * b / gcm;

        long cycle = n / length;
        long mantissa = n % length;

        long complementA = (long) Math.ceil((nb * mantissa * 1.0) / (na + nb)) * na;
        long complementB = (long) Math.ceil((na * mantissa * 1.0) / (na + nb)) * nb;

        long complement = mantissa == 0 ? 0 : Math.min(complementA, complementB) * gcm;
        return (int) ((cycle * lcm + complement) % 1000000007);
    }

    public int gcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        return gcm(min, max % min);
    }

}
