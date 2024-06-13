package com.dengwn.leetcode.solution.t1.h4;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-03-03
 **/
public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            Integer size = map.get(name);
            if (size != null) {
                int k = size;
                while (map.containsKey(newFolderNames(name, k))) {
                    k++;
                }
                map.put(name,k);
                name = newFolderNames(name, k);
            }
            map.put(name, 1);
            ans[i] = name;
        }

        return ans;
    }

    public String newFolderNames(String name, int k) {
        return name + "(" + k + ")";
    }


    public static void main(String[] args) {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        Solution1487 solution1487 = new Solution1487();
        System.out.println(Arrays.toString(solution1487.getFolderNames(names)));
    }
}
