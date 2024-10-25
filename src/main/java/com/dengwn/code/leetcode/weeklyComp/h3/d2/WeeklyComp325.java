package com.dengwn.code.leetcode.weeklyComp.h3.d2;

/**
 * @author dengwn
 * @date: 2022-12-25
 */
public class WeeklyComp325 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        for (int i = -n; i < 2 * n; i++) {
            if (words[(i + 3 * n) % n].equals(target)) {
                ans = Math.min(ans, Math.abs(startIndex - i));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int takeCharacters(String s, int k) {
        int length = s.length();
        if (length < 3 * k) {
            return -1;
        }
        int[] size = new int[3];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                size[0]++;
            } else if (s.charAt(i) == 'b') {
                size[1]++;
            } else {
                size[2]++;
            }
        }
        if (size[0] < k || size[1] < k || size[2] < k) {
            return -1;
        }

        int ans = length;
        for (int left = 0; left < length; left++) {
            int a = size[0];
            int b = size[1];
            int c = size[2];
            for (int right = left; right < length; right++) {
                if (s.charAt(right) == 'a') {
                    a--;
                } else if (s.charAt(right) == 'b') {
                    b--;
                } else {
                    c--;
                }
                if (a < k || b < k || c < k) {
                    ans = Math.min(ans, length - right + left);
                    break;
                }
                if (right == length - 1) {
                    ans = Math.min(ans, length - right + left - 1);
                }
            }
        }
        return ans;
    }

    public int maximumTastiness(int[] price, int k) {
        return 0;
    }


    public static void main(String[] args) {
        WeeklyComp325 weeklyComp325 = new WeeklyComp325();
        String[] words = {"pgmiltbptl", "jnkxwutznb", "bmeirwjars", "ugzyaufzzp", "pgmiltbptl", "sfhtxkmzwn", "pgmiltbptl", "pgmiltbptl", "onvmgvjhxa", "jyzdtwbwqp"};
        String target = "pgmiltbptl";
        int startIndex = 4;
        System.out.println(weeklyComp325.closetTarget(words, target, startIndex));

        System.out.println(weeklyComp325.takeCharacters("acbcc", 1));
    }



}
