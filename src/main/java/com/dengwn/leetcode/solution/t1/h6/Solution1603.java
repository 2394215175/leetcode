package com.dengwn.leetcode.solution.t1.h6;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1603 {
}

class ParkingSystem {
    int[] cars = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        cars[1] = big;
        cars[2] = medium;
        cars[3] = small;
    }

    public boolean addCar(int carType) {
        if (cars[carType] > 0) {
            cars[carType]--;
            return true;
        }
        return false;
    }
}
