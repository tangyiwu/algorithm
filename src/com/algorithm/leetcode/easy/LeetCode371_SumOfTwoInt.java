package com.algorithm.leetcode.easy;

public class LeetCode371_SumOfTwoInt {
    public int getSum(int a, int b) {
        return Add(a, b);
    }

    private int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
