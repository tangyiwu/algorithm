package com.algorithm.leetcode.easy;

public class LeetCode242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if ("".equals(s) && "".equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode242_ValidAnagram validAnagram = new LeetCode242_ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
        System.out.println(validAnagram.isAnagram("fe", "ja"));
        System.out.println(validAnagram.isAnagram("aacc", "ccac"));
    }
}
