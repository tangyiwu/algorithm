package com.algorithm.leetcode.easy;

public class LeetCode342_PowerOf4 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (true) {
            if (num == 1) {
                return true;
            }
            if (num % 4 == 0) {
                num /= 4;
            } else {
                return false;
            }
        }
    }
}
