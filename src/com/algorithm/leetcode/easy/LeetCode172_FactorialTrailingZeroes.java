package com.algorithm.leetcode.easy;

/**
 * 3! = 1*2*3=6
 * 4! = 1*2*3*4=24
 * 5! = 1*2*3*4*5=120
 */
public class LeetCode172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += (n /= 5);
        }
        return cnt;
    }

    public int trailingZeroes2(int n) {
        if (n < 5) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        return n / 5 + trailingZeroes2(n / 5);
    }

    public static void main(String[] args) {
        LeetCode172_FactorialTrailingZeroes zeroes = new LeetCode172_FactorialTrailingZeroes();
        System.out.println(zeroes.trailingZeroes(1));
        System.out.println(zeroes.trailingZeroes(2));
        System.out.println(zeroes.trailingZeroes(3));
        System.out.println(zeroes.trailingZeroes(4));
        System.out.println(zeroes.trailingZeroes(5));
        System.out.println(zeroes.trailingZeroes(10));
        System.out.println(zeroes.trailingZeroes(20));
        System.out.println(zeroes.trailingZeroes(30));
        System.out.println(zeroes.trailingZeroes(100));
        System.out.println(zeroes.trailingZeroes(1000));
        System.out.println(zeroes.trailingZeroes(10000));
        System.out.println(zeroes.trailingZeroes2(10000));
    }
}
