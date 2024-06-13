package com.dengwn.leetcode.solution.t2.h0;

/**
 * @author dengwenning
 * @since 2024/5/9
 **/
public class Solution2079 {

    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int index = 0;
        int temp = capacity;
        int ans = 0;
        while (index < n) {
            while (index < n && temp >= plants[index]) {
                temp -= plants[index];
                ans++;
                index++;
            }
            if (index < n){
                ans += 2 * index;
                temp = capacity;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2079 solution2079 = new Solution2079();
        System.out.println(solution2079.wateringPlants(new int[]{2,2,3,3},5));
    }
}
