package com.algorithm.leetcode.easy;

public class LeetCode326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 3) {
            return true;
        }
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        LeetCode326_PowerOfThree powerOfThree = new LeetCode326_PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(3));
        System.out.println(powerOfThree.isPowerOfThree(9));
        System.out.println(powerOfThree.isPowerOfThree(27));
        System.out.println(powerOfThree.isPowerOfThree(81));
    }
}
