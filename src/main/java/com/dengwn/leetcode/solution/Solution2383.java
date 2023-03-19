package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-03-13
 */
public class Solution2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        for (int e : energy) {
            sum += e;
        }
        int trainingHours = initialEnergy > sum ? 0 : sum + 1 - initialEnergy;
        for (int j : experience) {
            if (initialExperience <= j) {
                trainingHours += 1 + j - initialExperience;
                initialExperience = 2 * j + 1;
            } else {
                initialExperience += j;
            }
        }
        return trainingHours;
    }


    public static void main(String[] args) {
        Solution2383 solution2383 = new Solution2383();
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1, 1, 1, 1};
        int[] experience = {1, 1, 1, 50};
        System.out.println(solution2383.minNumberOfHours(initialEnergy, initialExperience, energy, experience));

    }
}
