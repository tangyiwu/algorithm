package com.algorithm.leetcode.easy;

/**
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class LeetCode28_StrIndex {
    public int indexOf(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i = 0; i < haystacks.length; i++) {
            if (haystacks[i] == needles[0]) {
                if (i + needles.length > haystacks.length) {
                    return -1;
                }
                boolean hit = true;
                for (int j = 1; j < needles.length; j++) {
                    hit &= (haystacks[i + j] == needles[j]);
                }
                if (hit) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode28_StrIndex strIndex = new LeetCode28_StrIndex();
        System.out.println(strIndex.indexOf("mississippi", "issipi"));
        System.out.println(strIndex.indexOf("aaa", "aa"));
    }
}
