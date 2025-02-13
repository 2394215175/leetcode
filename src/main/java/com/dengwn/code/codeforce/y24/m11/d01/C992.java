package com.dengwn.code.codeforce.y24.m11.d01;

import java.util.Scanner;

/**
 *
 * @author dengwenning
 * @since 2024/11/1
 **/
public class C992 {

    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long k = scan.nextLong();
        if (x == 0) {
            System.out.println(0);
            return;
        }
        long ans = ((2 * x - 1) % MOD * pow(2, k) + 1) % MOD;
        System.out.println(ans);
    }

    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res % MOD;
    }


}
