package com.algorithm.leetcode.easy;

public class LeetCode367_PerfectSquare {
    /**
     * 1        01
     * 4       100
     * 9      1001
     * 16    10000
     * 25    11001
     * 36   100100
     */
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        LeetCode367_PerfectSquare perfectSquare = new LeetCode367_PerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(1));
        System.out.println(perfectSquare.isPerfectSquare(2));
        System.out.println(perfectSquare.isPerfectSquare(3));
        System.out.println(perfectSquare.isPerfectSquare(4));
        System.out.println(perfectSquare.isPerfectSquare(8));
        System.out.println(perfectSquare.isPerfectSquare(9));
        System.out.println(perfectSquare.isPerfectSquare(16));
        System.out.println(perfectSquare.isPerfectSquare(2147483647));
        System.out.println(perfectSquare.isPerfectSquare(808201));
    }
}
