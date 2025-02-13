package com.dengwn.code.codeforce.y24.m11.d08;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/11/8
 **/
public class C1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
            }
            int[] ans = getMin(nums);
            System.out.print(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3]);
            System.out.println();
        }
    }

    public static int[] getMin(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= 4) {
                return new int[]{key, key, key, key};
            }
            if (value >= 2) {
                list.add(key);
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        int x = 1, y = 0;
        for (int i = 1; i < list.size(); i++) {
            int nx = list.get(i);
            int ny = list.get(i - 1);
            if (nx * y < x * ny) {
                x = nx;
                y = ny;
            }

        }
        return new int[]{x, x, y, y};
    }
}
