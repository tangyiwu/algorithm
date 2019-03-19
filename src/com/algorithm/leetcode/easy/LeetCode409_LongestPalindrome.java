package com.algorithm.leetcode.easy;

public class LeetCode409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int[] a = new int[128];
        for (char c : s.toCharArray()) {
            a[c]++;
        }
        int evens = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                evens++;
            }
        }
        int len = s.length();
        if (evens <= 1) {
            return len;
        }
        return len - evens + 1;
    }

    public static void main(String[] args) {
        LeetCode409_LongestPalindrome longestPalindrome = new LeetCode409_LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }
}
