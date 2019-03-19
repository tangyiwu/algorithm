package com.algorithm.leetcode.easy;

/**
 * 2 = 2
 * 3 = 3
 * 4 = 2*2
 * 5 = 5
 * 6 = 2*3
 * 8 = 2*2*2
 * 9 = 3*3
 * 10= 2*5
 */
public class LeetCode263_UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (true) {
            if (num == 1) {
                return true;
            }
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode263_UglyNumber uglyNumber = new LeetCode263_UglyNumber();
        System.out.println(uglyNumber.isUgly(2));
        System.out.println(uglyNumber.isUgly(3));
        System.out.println(uglyNumber.isUgly(5));
        System.out.println(uglyNumber.isUgly(6));
        System.out.println(uglyNumber.isUgly(8));
        System.out.println(uglyNumber.isUgly(14));
    }
}
