package com.dengwn.code.codeforce.m11.d04;

import java.util.Scanner;

/**
 *
 * @author dengwenning
 * @since 2024/11/4
 **/
public class Cf1016c {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[2][n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i / n][i % n] = scan.nextInt();
        }
        long ans = 0;
        int times = 0;
        int i = 0;
        int j = 0;
        while (times < 2 * n){
            //
        }
    }
}
