package com.dengwn.leetcode.solution.t0.h6.d8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/7/29
 **/
public class Solution682 {
    public int calPoints(String[] operations) {
        int ans = 0;
        List<Integer> st = new ArrayList<>();
        for (String operation : operations) {
            int n = st.size();
            switch (operation) {
                case "C":
                    st.remove(n - 1);
                    break;
                case "D":
                    st.add(st.get(n - 1) * 2);
                    break;
                case "+":
                    st.add(st.get(n - 1) + st.get(n - 2));
                    break;
                default:
                    st.add(Integer.parseInt(operation));
                    break;
            }
        }
        for (Integer i : st) {
            ans += i;
        }
        return ans;
    }
}
