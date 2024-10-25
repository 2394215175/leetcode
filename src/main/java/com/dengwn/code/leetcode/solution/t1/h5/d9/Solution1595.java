package com.dengwn.code.leetcode.solution.t1.h5.d9;

import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-06-20
 **/
public class Solution1595 {
    int ans = Integer.MAX_VALUE;
    int n;
    int m;

    public int connectTwoGroups(List<List<Integer>> cost) {
        n = cost.size();
        m = cost.get(0).size();
        int[] vis = new int[m];
        dfs(0, 0, vis, cost, 0);
        return ans;
    }

    public void dfs(int x, int y, int[] vis, List<List<Integer>> cost, int cur) {
        if (n == x) {
            if (y == m) {
                ans = Math.min(ans, cur);
            }
            return;
        }

        int m = vis.length;
        List<Integer> list = cost.get(x);
        for (int i = 0; i < m; i++) {
            if (++vis[i] == 1) {
                y++;
            }
            x++;
            cur += list.get(i);
            dfs(x, y, vis, cost, cur);
            cur -= list.get(i);
            x--;
            if (--vis[i] == 0) {
                y--;
            }
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> cost = new ArrayList<>();
//        cost.add(Arrays.asList(1, 3, 5));
//        cost.add(Arrays.asList(4, 1, 1));
//        cost.add(Arrays.asList(1, 5, 3));
////        cost.add(Arrays.asList(54, 60, 30));
//        Solution1595 solution1595 = new Solution1595();
//        System.out.println(solution1595.connectTwoGroups(cost));

//        System.out.println("abcd".hashCode());
//
//        System.out.println(Integer.toBinaryString(2987074));
//        System.out.println(Integer.parseInt("10110",2));

//        Long a = 1L;
//        Long b = 2L;
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//
//        System.out.println((2L >>> 32));
//        System.out.println((int)(2L ^ (2L >>> 32)));

        Long c = 3602879723213138L;
        Long d = c >>> 32;

        String s1 = Long.toBinaryString(c);
        for (int i = s1.length(); i < 64; i++) {
            s1 = "0" + s1;
        }
        System.out.println(s1);

        String s2 = Long.toBinaryString(d);
        for (int i = s2.length(); i < 64; i++) {
            s2 = "0" + s2;
        }
        System.out.println(s2);

        String s3 = Long.toBinaryString(c ^ d);
        for (int i = s3.length(); i < 64; i++) {
            s3 = "0" + s3;
        }
        System.out.println(s3);

        System.out.println((int) Long.parseLong(s3, 2));
        String substring = s3.substring(32, 64);

        String s4 = "";
        for (int i = 1; i < substring.length(); i++) {
            s4 += substring.charAt(i) == '1' ? '0' : '1';
        }

        System.out.println(Integer.parseInt(s4, 2));


//        long l3 = 24696061952L; //10111000000000000000000000000000000
//        int c3 = (int)l3; //-1073741824
//        System.out.println(Long.toBinaryString(l3));
//        System.out.println(Integer.toBinaryString(c3)); //1000000000000000000000000000000

    }
}
