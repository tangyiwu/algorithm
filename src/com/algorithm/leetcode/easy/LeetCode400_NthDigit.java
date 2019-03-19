package com.algorithm.leetcode.easy;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * 1,2,..., 9       9
 * 10, ..., 99      9*10 = 90
 * 100, ..., 999    9*10*10 = 900
 * 9000
 * 90000
 */
public class LeetCode400_NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        LeetCode400_NthDigit nthDigit = new LeetCode400_NthDigit();
        System.out.println(nthDigit.findNthDigit(3));
        System.out.println(nthDigit.findNthDigit(11));
        System.out.println(nthDigit.findNthDigit(10000));
        System.out.println(nthDigit.findNthDigit(Integer.MAX_VALUE));
    }
}
