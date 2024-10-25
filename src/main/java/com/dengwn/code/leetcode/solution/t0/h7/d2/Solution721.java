package com.dengwn.code.leetcode.solution.t0.h7.d2;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/7/15
 **/
public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        // key : email
        // val : index
        Map<String, List<Integer>> emailToIndex = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailToIndex.computeIfAbsent(accounts.get(i).get(j), k -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> result = new ArrayList<>();
        boolean[] vis = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (vis[i]) {
                continue;
            }
            TreeSet<String> emails = new TreeSet<>();
            TreeSet<String> bfs = new TreeSet<>();
            for (int j = 1; j < accounts.get(i).size(); j++) {
                bfs.add(accounts.get(i).get(j));
                emails.add(accounts.get(i).get(j));

            }
            vis[i] = true;
            while (!bfs.isEmpty()) {
                for (int j = bfs.size(); j > 0; j--) {
                    String curEmail = bfs.pollFirst();
                    for (Integer k : emailToIndex.get(curEmail)) {
                        if (vis[k]) {
                            continue;
                        }
                        for (int l = 1; l < accounts.get(k).size(); l++) {
                            bfs.add(accounts.get(k).get(l));
                            emails.add(accounts.get(k).get(l));
                        }
                        vis[k] = true;
                    }
                }
            }
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(i).get(0));
            merged.addAll(emails);
            result.add(merged);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution721 solution721 = new Solution721();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> result = solution721.accountsMerge(accounts);
        System.out.println(result);
    }
}
