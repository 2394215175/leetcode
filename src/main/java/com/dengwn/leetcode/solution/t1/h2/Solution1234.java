package com.dengwn.leetcode.solution.t1.h2;

/**
 * @author: dengwn
 * @date: 2023-02-13
 **/
public class Solution1234 {
    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int n = length / 4;
        int[] nums = new int[26];
        for (char c : chars) {
            nums[c - 'A']++;
        }

        int left = 0;
        int right = -1;
        int ans = length;
        while (left < length) {
            if (check(nums, n)) {
                ans = Math.min(ans, right - left + 1);
                nums[chars[left] - 'A']++;
                left++;
            }else if(right < length - 1){
                nums[s.charAt(++right) - 'A']--;
            }else{
                break;
            }
        }

        return ans;
    }

    /**
     * 校验函数，校验当前counts中四个字符的出现次数是否都小于等于limit；
     * 是返回true，否返回false
     */
    private boolean check(int[] counts, int limit) {
        if (counts['Q' - 'A'] > limit || counts['W' - 'A'] > limit || counts['E' - 'A'] > limit || counts['R' - 'A'] > limit) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution1234 solution1234 = new Solution1234();
        System.out.println(solution1234.balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
}
