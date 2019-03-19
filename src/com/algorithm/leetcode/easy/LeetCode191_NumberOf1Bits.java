package com.algorithm.leetcode.easy;

public class LeetCode191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>= 1;
            if (bit > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode191_NumberOf1Bits numberOf1Bits  = new LeetCode191_NumberOf1Bits();
        System.out.println(numberOf1Bits.hammingWeight(11));
    }
}
