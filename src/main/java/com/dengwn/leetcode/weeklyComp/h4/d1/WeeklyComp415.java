package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/15
 **/
public class WeeklyComp415 {

    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n - 2];
        int[] ans = new int[2];
        int index = 0;
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] == 2) {
                ans[index++] = num;
            }
        }
        return ans;
    }

    public long maxScore(int[] a, int[] b) {
        long[] dp = new long[4];
        Arrays.fill(dp, Long.MIN_VALUE / 2);
        for (int j : b) {
            dp[3] = Math.max(dp[3], dp[2] + (long) a[3] * j);
            dp[2] = Math.max(dp[2], dp[1] + (long) a[2] * j);
            dp[1] = Math.max(dp[1], dp[0] + (long) a[1] * j);
            dp[0] = Math.max(dp[0], (long) a[0] * j);
        }
        return dp[3];
    }

    // Trie 节点类
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];  // 假设只包含小写字母
            isEndOfWord = false;
        }
    }

    // 构建 Trie 树类
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 插入单词到 Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        // 在 target 中从索引 start 开始查找可能的前缀
        public List<Integer> searchPrefixes(String target, int start) {
            TrieNode node = root;
            List<Integer> validEndIndices = new ArrayList<>();
            for (int i = start; i < target.length(); i++) {
                int index = target.charAt(i) - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                validEndIndices.add(i + 1);  // 记录前缀的结束位置
            }
            return validEndIndices;
        }
    }

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        Trie trie = new Trie();

        // 将 words 中的所有单词插入字典树中
        for (String word : words) {
            trie.insert(word);
        }

        // 初始化 dp 数组，长度为 n+1，默认值为一个很大的数
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        dp[0] = 0;

        // 将起始位置 0 放入队列
        queue.offer(0);

        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            int i = queue.poll();

            // 利用字典树查找所有以 target[i:] 为前缀的可能位置
            List<Integer> endIndices = trie.searchPrefixes(target, i);
            for (int endIndex : endIndices) {
                if (dp[endIndex] > dp[i] + 1) {
                    dp[endIndex] = dp[i] + 1;
                    queue.offer(endIndex);
                }
            }
        }


        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }


    public static void main(String[] args) {
        WeeklyComp415 weeklyComp415 = new WeeklyComp415();

//        int[] a = {-1, 4, 5, -2};
//        int[] b = {-5, -1, -3, -2, -4};
//        System.out.println(weeklyComp415.maxScore(a, b));


        String[] words = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        System.out.println(weeklyComp415.minValidStrings(words, target));


    }
}
