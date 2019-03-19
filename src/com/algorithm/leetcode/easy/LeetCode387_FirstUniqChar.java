package com.algorithm.leetcode.easy;

public class LeetCode387_FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || s.length() <= 0) {
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
