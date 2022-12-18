package com.dengwn.leetcode.weeklyComp;

import java.util.HashSet;
import java.util.List;

/**
 * @author dengwn
 * @date: 2022-12-18
 */
public class WeeklyComp324 {
    public int similarPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isSimilar(String a, String b) {
        boolean[] char1 = new boolean[26];
        boolean[] char2 = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            char1[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            char2[b.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (char1[i] != char2[i]) {
                return false;
            }
        }
        return true;
    }

    public int smallestValue(int n) {
        if (factorization(n, 0) == n) {
            return n;
        }
        return smallestValue(factorization(n, 0));
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int factorization(int n, int sum) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return factorization(n / i, sum + i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        WeeklyComp324 weeklyComp324 = new WeeklyComp324();
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(weeklyComp324.similarPairs(words));
        System.out.println(weeklyComp324.smallestValue(99957));
        int factorization = weeklyComp324.factorization(15, 0);

        System.out.println(factorization);

    }
}
