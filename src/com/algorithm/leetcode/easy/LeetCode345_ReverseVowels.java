package com.algorithm.leetcode.easy;

public class LeetCode345_ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j) {
                if (!isVowel(chars[i])) {
                    i++;
                } else {
                    break;
                }
            }
            while (i < j) {
                if (!isVowel(chars[j])) {
                    j--;
                } else {
                    break;
                }
            }
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        LeetCode345_ReverseVowels reverseVowels = new LeetCode345_ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("hello"));
        System.out.println(reverseVowels.reverseVowels("leetcode"));
    }
}
