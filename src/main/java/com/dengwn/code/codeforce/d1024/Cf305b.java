package com.dengwn.code.codeforce.d1024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dengwenning
 * @since 2024/10/24
 **/
public class Cf305b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long p = scanner.nextLong();
        long q = scanner.nextLong();
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        if (n >= 2 && arr[n - 1] == 1) {
            arr[n - 2] = arr[n - 2] + arr[n - 1];
            arr[n - 1] = 0;
            n -= 1;
        }

        int i = 0;
        while (q != 0) {
            if (i >= n || p / q != arr[i]) {
                System.out.println("NO");
                return;
            }
            p %= q;
            long temp = p;
            p = q;
            q = temp;
            i++;
        }
        System.out.println(i == n ? "YES" : "NO");
        scanner.close();
    }
}
