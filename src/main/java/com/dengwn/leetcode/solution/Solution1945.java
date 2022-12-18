package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-12-15
 */
public class Solution1945 {
    public int getLucky(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a' + 1;
            ans += cur / 10 + cur % 10;
        }

        for (int i = 0; i < k - 1; i++) {
            int temp = 0;
            while (ans > 0) {
                temp += ans % 10;
                ans /= 10;
            }
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1945 solution1945 = new Solution1945();
        System.out.println(solution1945.getLucky("iiii", 1));
    }
}

// abcdefghij
