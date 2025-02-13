package com.dengwn.code.leetcode.weeklyComp.h4.d3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2025/1/19
 **/
public class WeeklyComp433 {

    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += preSum[i + 1] - preSum[Math.max(0, i - nums[i])];
        }
        return ans;
    }

    int MOD = 1000000007;
    int MAX;
    // 阶乘数组
    long[] fact;
    // 阶乘逆元数组
    long[] invFact;

    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        MAX = n;
        fact = new long[n + 1];
        invFact = new long[n + 1];
        preprocessFactorials();
        long ans = 0;
        long[][] memo = new long[n][k];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            ans += nums[i] * 2L;
            ans %= MOD;
            for (int j = 2; j <= k; j++) {
                long combination1 = memo[i][j - 1] == 0 ? combination(i, j - 1) : memo[i][j - 1];
                ans += nums[i] * combination1;
                memo[i][j - 1] = combination1;
                ans %= MOD;
                long combination2 = memo[n - 1 - i][j - 1] == 0 ? combination(n - 1 - i, j - 1) : memo[n - 1 - i][j - 1];
                ans += nums[i] * combination2;
                memo[n - 1 - i][j - 1] = combination2;
                ans %= MOD;
            }
        }
        return (int) (ans % MOD);
    }


    // 快速幂：计算 (base^exp) % mod
    public long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // 预处理阶乘和阶乘逆元
    public void preprocessFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            // 计算 i!
            fact[i] = fact[i - 1] * i % MOD;
        }
        // 费马小定理计算逆元
        invFact[MAX] = modPow(fact[MAX], MOD - 2, MOD);
        for (int i = MAX - 1; i >= 0; i--) {
            // 根据递推关系计算阶乘逆元
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // 计算 C(n, m) % MOD
    public long combination(int n, int m) {
        if (m > n || m < 0) {
            return 0;
        }
        return fact[n] * invFact[m] % MOD * invFact[n - m] % MOD;
    }

    Map<String, Long> memo = new HashMap<>();

    public long minCost(int n, int[][] cost) {
        int[] index = new int[n];
        Arrays.fill(index, -1);
        return dfs(n, cost, index, 0);
    }

    public long dfs(int n, int[][] cost, int[] index, int i) {
        if (i == n) {
            return 0;
        }
        String key = index.toString() + i;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long nx = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (i - 1 >= 0 && j == index[i - 1]) {
                continue;
            }
            if (i >= n / 2 && j == index[n - 1 - i]) {
                continue;
            }
            index[i] = j;
            nx = Math.min(nx, (dfs(n, cost, index, i + 1) + cost[i][j]));
            index[i] = -1;
        }
        memo.put(key, nx);
        return nx;
    }


    public static void main(String[] args) {
        WeeklyComp433 weeklyComp433 = new WeeklyComp433();

//        int[] nums = {3, 1, 1, 2};
//        System.out.println(weeklyComp433.subarraySum(nums));


//        int[] nums = {0, 2, 1};
//        System.out.println(weeklyComp433.minMaxSums(nums, 1));

        int[][] cost = {{3, 5, 7}, {6, 2, 9}, {4, 8, 1}, {7, 3, 5}};
        System.out.println(weeklyComp433.minCost(4, cost));
    }
}
