package com.dengwn.code.leetcode.solution.t0.h2.d0;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution208 {
}

class Trie {

    public Trie[] children;
    public boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (char c : array) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    private Trie searchPrefix(String word) {
        char[] array = word.toCharArray();
        Trie node = this;
        for (char c : array) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */