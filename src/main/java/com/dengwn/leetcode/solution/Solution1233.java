package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-08
 **/
public class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        String pre = folder[0] ;
        ans.add(pre);
        for (int i = 1; i < folder.length; i++) {
            String s = folder[i];
            if (!s.startsWith(pre+ "/")) {
                pre = s;
                ans.add(pre);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        Solution1233 solution1233 = new Solution1233();
        System.out.println(solution1233.removeSubfolders(folder));
    }

}

