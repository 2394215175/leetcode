package com.dengwn.code.leetcode.weeklyComp.h3.d8;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/13
 **/
public class WeeklyComp380 {

    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            max = Math.max(max, count.get(num));
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans += entry.getValue() == max ? max : 0;
        }
        return ans;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        int ni = a.length();
        int nj = b.length();
        List<Integer> cntI = new ArrayList<>();
        List<Integer> cntJ = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + ni <= n && s.substring(i, i + ni).equals(a)) {
                cntI.add(i);
            }
            if (i + nj <= n && s.substring(i, i + nj).equals(b)) {
                cntJ.add(i);
            }
        }
        int l1 = 0;
        int l2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (l1 < cntI.size() && !cntJ.isEmpty()) {
            int i = cntI.get(l1);
            int j = cntJ.get(l2);
            if (Math.abs(i - j) <= k && !ans.contains(i)) {
                ans.add(i);
            }
            if (i < j || l2 == cntJ.size() - 1) {
                l1++;
            } else {
                if (l2 < cntJ.size() - 1) {
                    l2++;
                }
            }
        }
        return ans;
    }

    public long findMaximumNumber(long k, int x) {
        long left = 0;
        long right = k;
        return 0;
    }

    public static void main(String[] args) {
        WeeklyComp380 weeklyComp380 = new WeeklyComp380();

        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 2;
        System.out.println(weeklyComp380.beautifulIndices(s, a, b, k));
    }
}
