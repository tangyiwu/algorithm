package com.algorithm.leetcode.easy;

/**
 * 回文数判断
 * eg: 121
 */
public class LeetCode9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rec = 0;
        int y = x;
        while (y != 0) {
            int pop = y % 10;
            y /= 10;
            rec = rec * 10 + pop;
        }
        return x == rec;
    }

    public static void main(String[] args) {
        LeetCode9_PalindromeNumber palindromeNumber = new LeetCode9_PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(1212));
        System.out.println(palindromeNumber.isPalindrome(12321));
    }
}
