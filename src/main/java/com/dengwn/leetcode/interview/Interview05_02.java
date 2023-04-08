package com.dengwn.leetcode.interview;

/**
 * @author: dengwn
 * @date: 2023-03-02
 **/
public class Interview05_02 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double bit = 0.5;
        while (num > 0 && sb.length() < 9) {
            if (num >= bit) {
                num -= bit;
                sb.append("1");
            } else {
                sb.append("0");
            }
            bit /= 2;
        }
        return num == 0.0 ? sb.toString() : "ERROR";
    }

    public static void main(String[] args) {
        Interview05_02 interview05_02 = new Interview05_02();
        System.out.println(interview05_02.printBin(0.1));
    }
}
