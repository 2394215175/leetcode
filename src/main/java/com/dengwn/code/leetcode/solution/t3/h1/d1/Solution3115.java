package com.dengwn.code.leetcode.solution.t3.h1.d1;

/**
 * @author dengwenning
 * @since 2024/7/2
 **/
public class Solution3115 {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] primes = new boolean[101];
        primes[1] = true;
        for (int i = 2; i < 101; i++) {
            if (primes[i]) {
                continue;
            }
            for (int j = 2; i * j < 101; j++) {
                primes[i * j] = true;
            }
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (!primes[nums[l]] && !primes[nums[r]]) {
                return r - l;
            }
            if (primes[nums[l]]) {
                l++;
            }
            if (primes[nums[r]]) {
                r--;
            }
        }
        return 0;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3115 solution3115 = new Solution3115();
        System.out.println(solution3115.maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
    }
}
