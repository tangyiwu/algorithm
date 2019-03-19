package com.algorithm.leetcode.easy;

public class LeetCode190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int lowBit = n & 1;
            n >>= 1;
            result = (result << 1) | lowBit;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode190_ReverseBits reverseBits = new LeetCode190_ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
}
