package com.algorithm.leetcode.easy;

/**
 * abca
 */
public class LeetCode680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1, false);
    }

    private boolean check(String s, int left, int right, boolean deleted) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return check(s, left + 1, right - 1, deleted);
        } else {
            if (deleted) {
                return false;
            }
            return check(s, left + 1, right, true) || check(s, left, right - 1, true);
        }
    }

    public static void main(String[] args) {
        LeetCode680_ValidPalindromeII validPalindromeII = new LeetCode680_ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("a"));
        System.out.println(validPalindromeII.validPalindrome("aba"));
        System.out.println(validPalindromeII.validPalindrome("abca"));
        System.out.println(validPalindromeII.validPalindrome("abbca"));
        System.out.println(validPalindromeII.validPalindrome("abc"));
        System.out.println(validPalindromeII.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
