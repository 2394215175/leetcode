package com.dengwn.code.leetcode.weeklyComp.h3.d8;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/14
 **/
public class WeeklyComp388 {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        int n = capacity.length;
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum > 0) {
                sum -= capacity[i];
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        int temp = 0;
        while (temp < k) {
            ans += Math.max(0, happiness[n - 1 - temp] - temp);
            temp++;
        }
        return ans;
    }

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<String>[] sets = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new TreeSet<>((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        }
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                for (int k = j + 1; k <= str.length(); k++) {
                    String s = str.substring(j, k);
                    sets[i].add(s);
                }
            }
            for (String s : sets[i]) {
                map.merge(s, 1, Integer::sum);
            }
        }

        for (int i = 0; i < n; i++) {
            for (String s : sets[i]) {
                if (map.get(s) == 1) {
                    ans[i] = s;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp388 weeklyComp388 = new WeeklyComp388();

        String[] arr = {"vbb","grg","lexn","oklqe","yxav"};
        System.out.println(Arrays.toString(weeklyComp388.shortestSubstrings(arr)));

    }
}
