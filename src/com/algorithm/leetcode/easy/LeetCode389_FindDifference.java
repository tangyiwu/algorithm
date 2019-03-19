package com.algorithm.leetcode.easy;

public class LeetCode389_FindDifference {
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'a']++;
        }
        int p = -1;
        for (int i = 0; i < 26; i++) {
            if (b[i] - a[i] == 1) {
                p = i;
                break;
            }
        }
        return (char) ('a' + p);
    }
}
