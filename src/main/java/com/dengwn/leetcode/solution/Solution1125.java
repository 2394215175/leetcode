package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-04-08
 */
public class Solution1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }

        int m = people.size();
        int u = 1 << n;
        long[][] f = new long[m + 1][u];
        Arrays.fill(f[0], (1L << m) - 1);
        f[0][0] = 0;
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (String s : people.get(i)) {
                mask |= 1 << map.get(s);
            }

            for (int j = 1; j < u; ++j) {
                // 不选 mask
                long res = f[i][j];
                // 选 mask
                long res2 = f[i][j & ~ mask] | (1L << i);
                f[i + 1][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
            }
        }

        long res = f[m][u - 1];
        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < m; ++i){
            if (((res >> i) & 1) > 0){
                // 所有在 res 中的下标
                ans[j++] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1125 solution1125 = new Solution1125();
        String[] req_skills = {"mmcmnwacnhhdd","vza","mrxyc"};
        String[][] people = {{"mmcmnwacnhhdd"},{},{}, {"vza","mrxyc"}};

        List<List<String>> input = new ArrayList<>();
        for (String[] strings : people) {
            input.add(Arrays.asList(strings));
        }
        System.out.println(Arrays.toString(solution1125.smallestSufficientTeam(req_skills, input)));

    }
}
