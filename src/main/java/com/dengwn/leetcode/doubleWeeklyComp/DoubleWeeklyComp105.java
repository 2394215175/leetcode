package com.dengwn.leetcode.doubleWeeklyComp;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-05-27
 */
public class DoubleWeeklyComp105 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int diff = money - prices[0] - prices[1];
        return diff >= 0 ? diff : money;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = n + 2;
        }
        dp[0] = 0;
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (set.contains(str)) {
                    System.out.println(str);
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            if (dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[n];
    }

    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        long ans = 1;
        int negNum = 0;
        int n = 0;
        for (int num : nums) {
            if (num > 0) {
                ans *= num;
                n++;
            }
            if (num < 0) {
                negNum++;
            }
        }
        for (int i = 0; i < negNum / 2 * 2; i++) {
            ans *= nums[i];
            n++;
        }
        return n == 0 ? 0 : ans;
    }


    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (gcd(num, nums[j]) > 1) {
                    if (numToIndex.containsKey(nums[j])) {
                        union(parent, rank, i, numToIndex.get(nums[j]));
                    }
                }
            }
        }

        return find(parent, 0) == find(parent, n - 1);
    }


    public static void main(String[] args) {
        DoubleWeeklyComp105 doubleWeeklyComp105 = new DoubleWeeklyComp105();

//        int[] prices = {3, 2, 3};
//        int money = 3;
//        System.out.println(doubleWeeklyComp105.buyChoco(prices, money));

//        int[] nums = {-1, 0};
//        System.out.println(doubleWeeklyComp105.maxStrength(nums));

//        String s = "kevlplxozaizdhxoimmraiakbak";
//        String[] dictionary = {"yv", "bmab", "hv", "bnsll", "mra", "jjqf", "g", "aiyzi", "ip", "pfctr", "flr", "ybbcl", "biu",
//                "ke", "lpl", "iak", "pirua", "ilhqd", "zdhx", "fux", "xaw", "pdfvt", "xf", "t", "wq", "r", "cgmud", "aokas", "xv",
//                "jf", "cyys", "wcaz", "rvegf", "ysg", "xo", "uwb", "lw", "okgk", "vbmi", "v", "mvo", "fxyx", "ad", "e"};
//        System.out.println(doubleWeeklyComp105.minExtraChar(s, dictionary));


        int[] nums = {4, 3, 12, 8};
        System.out.println(doubleWeeklyComp105.canTraverseAllPairs(nums));
    }

//    "zaioimbak"
//            ["yv","bmab","hv","bnsll","mra","jjqf","g","aiyzi","ip","pfctr","flr","ybbcl","biu","ke","lpl","iak","pirua","ilhqd","zdhx","fux","xaw","pdfvt","xf","t","wq","r","cgmud","aokas","xv","jf","cyys","wcaz","rvegf","ysg","xo","uwb","lw","okgk","vbmi","v","mvo","fxyx","ad","e"]

}