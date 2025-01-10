package com.dengwn.code.leetcode.solution.t2.h2.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/6
 **/
public class Solution2241 {

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[] {0,0,1,2,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));

    }
}

class ATM {
    int[] den;
    int[] cnt;

    public ATM() {
        den = new int[]{20, 50, 100, 200, 500};
        cnt = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (amount >= den[i]) {
                int size = Math.min(cnt[i], amount / den[i]);
                amount -= size * den[i];
                ans[i] = size;
            }
        }
        if (amount != 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            cnt[i] -= ans[i];
        }
        return ans;
    }
}
