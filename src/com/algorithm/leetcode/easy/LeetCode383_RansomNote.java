package com.algorithm.leetcode.easy;

public class LeetCode383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() == 0) {
            return true;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            a[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            b[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode383_RansomNote ransomNote = new LeetCode383_RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
        System.out.println(ransomNote.canConstruct("", ""));
        System.out.println(ransomNote.canConstruct("ab", "ba"));
        System.out.println(ransomNote.canConstruct("", "ba"));
    }
}
