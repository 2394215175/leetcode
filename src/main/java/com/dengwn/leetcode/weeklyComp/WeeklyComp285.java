package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-02-18
 **/
public class WeeklyComp285 {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            while (i > 0) {
                set.add(i);
                i /= 10;
            }
        }

        for (int i : arr2) {
            while (i > 0) {
                if (set.contains(i)) {
                    max = Math.max(max, String.valueOf(i).length());
                    break;
                }
                i /= 10;
            }

        }

        return max;
    }

    int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = 0;
        int res = -1;
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    int step = 1;
                    int cur = mat[i][j];
                    while (i + step * dirs[k][0] >= 0 && i + step * dirs[k][0] < m && j + step * dirs[k][1] >= 0 && j + step * dirs[k][1] < n) {
                        cur = cur * 10 + mat[i + step * dirs[k][0]][j + step * dirs[k][1]];
                        map.merge(cur, 1, Integer::sum);
                        step++;
                    }
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (isPrime(entry.getKey())) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    res = entry.getKey();
                }
            }
        }

        return res;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long countPrefixSuffixPairs2(String[] words) {
        int length = words.length;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int j = 0;
            while (j < word.length()) {
                String prefix = word.substring(0, j + 1);
                String suffix = word.substring(word.length() - j - 1);
                if (prefix.equals(suffix)) {
                    List<Integer> list = map.getOrDefault(prefix, new ArrayList<>());
                    list.add(i);
                    map.put(prefix, list);
                }
                j++;
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.get(words[i]);
            if (list == null) {
                continue;
            }

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > i) {
                    res += list.size() - j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WeeklyComp285 weeklyComp285 = new WeeklyComp285();
//        String[] words = {"pa","papa","ma","mama"};
//        System.out.println(weeklyComp285.countPrefixSuffixPairs(words));

//        int[] arr1 = {1, 10, 100};
//        int[] arr2 = {1000};
//        System.out.println(weeklyComp285.longestCommonPrefix(arr1, arr2));
//
//        int[][] mat = {{7}};
//        System.out.println(weeklyComp285.mostFrequentPrime(mat));

        String[] words = {"pa", "papa", "ma", "mama"};
        System.out.println(weeklyComp285.countPrefixSuffixPairs2(words));
    }


}
