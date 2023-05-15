package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-05-06
 */
public class Solution1419 {
    // 数组比哈希表快。's' 保证 "croak" 中的任意字符都不会越界
    private static final char[] PREVIOUS = new char['s'];

    static { // 预处理每个字母在 "croak" 中的上一个字母
        char[] s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++){
            PREVIOUS[s[i]] = s[i - 1];
        }
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int['s'];
        for (char ch : croakOfFrogs.toCharArray()) {
            char pre = PREVIOUS[ch]; // pre 为 ch 在 "croak" 中的上一个字母
            if (cnt[pre] > 0) { // 如果有青蛙发出了 pre 的声音
                cnt[pre]--; // 复用一只
            }
            else if (ch != 'c'){
                // 否则青蛙必须从 'c' 开始蛙鸣
                return -1; // 不符合要求
            }
            cnt[ch]++; // 发出了 ch 的声音
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0){
            return -1; // 有发出其它声音的青蛙，不符合要求
        }
        return cnt['k']; // 最后青蛙们都发出了 'k' 的声音
    }

    public static void main(String[] args) {
        Solution1419 solution1419 = new Solution1419();
        System.out.println(solution1419.minNumberOfFrogs("croakcroak"));
    }
}
