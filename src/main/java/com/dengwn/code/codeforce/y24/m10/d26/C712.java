package com.dengwn.code.codeforce.y24.m10.d26;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author dengwenning
 * @since 2024/10/29
 **/
public class C712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[] arr = new int[3];
        Arrays.fill(arr, y);
        int ans = 0;
        int i = 0;
        while (arr[0] < x || arr[1] < x || arr[2] < x) {
            arr[i % 3] = arr[(i + 1) % 3] + arr[(i + 2) % 3] - 1;
            i++;
            ans++;
        }
        System.out.println(ans);
    }
}
