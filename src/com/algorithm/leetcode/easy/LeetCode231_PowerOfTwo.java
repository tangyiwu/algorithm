package com.algorithm.leetcode.easy;

public class LeetCode231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (1 << i == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode231_PowerOfTwo powerOfTwo = new LeetCode231_PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(1));
        System.out.println(powerOfTwo.isPowerOfTwo(2));
        System.out.println(powerOfTwo.isPowerOfTwo(4));
        System.out.println(powerOfTwo.isPowerOfTwo(32));
        System.out.println(powerOfTwo.isPowerOfTwo(1024));
        System.out.println(powerOfTwo.isPowerOfTwo(1 << 30));
        System.out.println(powerOfTwo.isPowerOfTwo(1 << 31));
        System.out.println(powerOfTwo.isPowerOfTwo(Integer.MAX_VALUE));
    }
}
