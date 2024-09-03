package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/8/18
 **/
public class WeeklyComp411 {

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] count1 = new int[n + 1];
        int[] count0 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (array[i] == '0') {
                count0[i + 1] = count0[i] + 1;
                count1[i + 1] = count1[i];
            } else {
                count0[i + 1] = count0[i];
                count1[i + 1] = count1[i] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (count1[j] - count1[i] <= k || count0[j] - count0[i] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] energy = new long[n][2];
        // 下标为0 表示当前在A， 下标为1 表示当前在B
        energy[0][0] = energyDrinkA[0];
        energy[0][1] = energyDrinkB[0];
        for (int i = 1; i < n; i++) {
            energy[i][0] = Math.max(energy[i - 1][0] + energyDrinkA[i], energy[i - 1][1]);
            energy[i][1] = Math.max(energy[i - 1][1] + energyDrinkB[i], energy[i - 1][0]);
        }
        return Math.max(energy[n - 1][0], energy[n - 1][1]);
    }

    public String largestPalindrome(int n, int k) {
        if (k == 1 || k == 3 || k == 9) {
            return calc1_3_9(n);
        }
        if (k == 2) {
            return calc2(n);
        }
        if (k == 4) {
            return calc4(n);
        }
        if (k == 5) {
            return calc5(n);
        }
        if (k == 6) {
            return calc6(n);
        }
        if (k == 7) {
            return calc7(n);
        }
        if (k == 8) {
            return calc8(n);
        }
        return "";
    }

    public String calc1_3_9(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("9");
        }
        return sb.toString();
    }

    public String calc2(int n) {
        if (n < 2) {
            return "8";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("8");
        for (int i = 0; i < n - 2; i++) {
            sb.append("9");
        }
        sb.append("8");
        return sb.toString();
    }

    public String calc4(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 4) {
            for (int i = 0; i < n; i++) {
                sb.append("8");
            }
            return sb.toString();
        }
        sb.append("88");
        for (int i = 0; i < n - 4; i++) {
            sb.append("9");
        }
        sb.append("88");
        return sb.toString();
    }

    public String calc5(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 2) {
            return "5";
        }
        sb.append("5");
        for (int i = 0; i < n - 2; i++) {
            sb.append("9");
        }
        sb.append("5");
        return sb.toString();
    }

    public String calc6(int n) {
        if (n == 3) {
            return "888";
        }
        if (n == 2) {
            return "66";
        }
        if (n == 1) {
            return "6";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("8");
        for (int i = 0; i < n - 2; i++) {
            sb.append("9");
        }
        sb.append("8");
        if (n % 2 == 0) {
            sb.replace(n / 2 - 1, n / 2 + 1, "77");
        } else {
            sb.replace(n / 2, n / 2 + 1, "8");
        }
        return sb.toString();
    }

    public String calc7(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '9');
        int mod = mod7(new String(chars));
        if (mod == 0) {
            return new String(chars);
        }
        char[] chars1 = new char[n];
        Arrays.fill(chars1, '0');
        for (int i = 1; i <= 9; i++) {
            if (n % 2 == 0) {
                // 偶数
                chars1[n / 2 - 1] = (char) ('0' + i);
                chars1[n / 2] = (char) ('0' + i);
            } else {
                chars1[n / 2] = (char) ('0' + i);
            }
            if (mod == mod7(new String(chars1))) {
                for (int j = 0; j < n; j++) {
                    chars[j] = (char) ('0' + chars[j] - chars1[j]);
                }
                return new String(chars);
            }
        }
        return "";
    }

    public String calc8(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 6) {
            for (int i = 0; i < n; i++) {
                sb.append("8");
            }
            return sb.toString();
        }
        sb.append("888");
        for (int i = 0; i < n - 6; i++) {
            sb.append("9");
        }
        sb.append("888");
        return sb.toString();
    }

    public int mod7(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 每次对7取模
            result = (result * 10 + (s.charAt(i) - '0')) % 7;
        }
        return result;
    }


    public static void main(String[] args) {
        WeeklyComp411 weeklyComp411 = new WeeklyComp411();

//        String s = "10101";
//        int k = 1;
//        System.out.println(weeklyComp411.countKConstraintSubstrings(s, k));

        System.out.println(weeklyComp411.largestPalindrome(3, 7));
    }
}
