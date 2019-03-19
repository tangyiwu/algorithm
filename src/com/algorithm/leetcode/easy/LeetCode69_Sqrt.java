package com.algorithm.leetcode.easy;

/**
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class LeetCode69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        for (int i = 1; i <= x / 2; i++) {
            if ((long) i * i > Integer.MAX_VALUE || i * i > x) {
                return i - 1;
            }
        }
        return x / 2;
    }

    public static void main(String[] args) {
        LeetCode69_Sqrt sqrt = new LeetCode69_Sqrt();
        System.out.println(sqrt.mySqrt(1));
        System.out.println(sqrt.mySqrt(2));
        System.out.println(sqrt.mySqrt(3));
        System.out.println(sqrt.mySqrt(4));
        System.out.println(sqrt.mySqrt(5));
        System.out.println(sqrt.mySqrt(8));
        System.out.println(sqrt.mySqrt(9));
        System.out.println(sqrt.mySqrt(10));
        System.out.println(sqrt.mySqrt(15));
        System.out.println(sqrt.mySqrt(25));
        System.out.println(sqrt.mySqrt(100));
        System.out.println(sqrt.mySqrt(2147395599));
        System.out.println(sqrt.mySqrt(2147395600));
        System.out.println(sqrt.mySqrt(2147483647));
    }
}
