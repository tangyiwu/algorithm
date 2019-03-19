package com.algorithm.leetcode.easy;

public class LeetCode125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j) {
                char c = Character.toLowerCase(s.charAt(i));
                boolean isAlpha = c >= 'a' && c <= 'z' || (c >= '0' && c <= '9');
                if (isAlpha) {
                    break;
                } else {
                    i++;
                }
            }
            while (i < j) {
                char c = Character.toLowerCase(s.charAt(j));
                boolean isAlpha = (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
                if (isAlpha) {
                    break;
                } else {
                    j--;
                }
            }
            if (i < j) {
                boolean isPalindrome = (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j)));
                if (isPalindrome) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode125_ValidPalindrome validPalindrome = new LeetCode125_ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome("abc ba"));
        System.out.println(validPalindrome.isPalindrome("0P"));
    }
}
