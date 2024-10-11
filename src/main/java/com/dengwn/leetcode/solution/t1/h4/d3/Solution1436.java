package com.dengwn.leetcode.solution.t1.h4.d3;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/10/8
 **/
public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        paths.forEach(p -> start.add(p.get(0)));
        for (List<String> path : paths) {
            if (!start.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
