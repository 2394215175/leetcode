package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/8/31
 **/
public class DoubleWeeklyComp138 {

    public int generateKey(int num1, int num2, int num3) {
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        int ans = 0;
        for (int i = 3; i >= 0; i--) {
            ans *= 10;
            ans += num[i];
        }
        return ans;
    }

    public String stringHash(String s, int k) {
        int n = s.length();
        int m = n / k;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a';
            ans[i / k] += j;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append((char) ((ans[i] % 26) + 'a'));
        }
        return sb.toString();
    }

    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        long sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] * o1[1] - o1[0] * o2[1]);
        for (int i = 0; i < n; i++) {
            sum += damage[i];
            pq.offer(new int[]{damage[i], (health[i] + power - 1) / power});
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            ans += p[1] * sum;
            sum -= p[0];
        }

        return ans;
    }


    public long countGoodIntegers(int n, int k) {
        int[] pow10 = new int[n];
        pow10[0] = 1;
        for (int i = 1; i < n; i++) {
            pow10[i] = pow10[i - 1] * 10 % k;
        }
        int m = (n + 1) / 2;
        int dfs = dfs(0, 0, n, k, m, pow10);
        return dfs;
    }

    private int dfs(int i, int j, int n, int k, int m, int[] pow10) {
        if (i == m) {
            return j == 0 ? 1 : 0;
        }
        // 贪心：从大到小枚举
        int res = 0;
        for (int d = 9; d >= 0; d--) {
            int j2;
            int num2;
            if (n % 2 > 0 && i == m - 1) { // 正中间
                j2 = (j + d * pow10[i]) % k;
            } else {
                j2 = (j + d * (pow10[i] + pow10[n - 1 - i])) % k;
            }
            res += dfs(i + 1, j2, n, k, m, pow10);
        }
        return res;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp138 doubleWeeklyComp138 = new DoubleWeeklyComp138();

//        System.out.println(doubleWeeklyComp138.generateKey(987, 879, 798));


//        int power = 62;
//        int[] damage = {80, 79};
//        int[] health = {86, 13};
//        System.out.println(doubleWeeklyComp138.minDamage(power, damage, health));


        System.out.println(doubleWeeklyComp138.countGoodIntegers(3, 5));
    }
}
