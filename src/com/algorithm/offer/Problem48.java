package com.algorithm.offer;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class Problem48 {
    public int findNotDuplicateCharLength(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int[] table = new int[26];
        int curLen = 0;
        int maxLen = 0;
        Arrays.fill(table, -1);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int tableIndex = c - 'a';
            if (table[tableIndex] == -1 || i - table[tableIndex] > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - table[tableIndex];
            }
            table[tableIndex] = i;
        }
        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        Problem48 problem48 = new Problem48();
        System.out.println(problem48.findNotDuplicateCharLength("abcdcbaxyzipqaabab"));
    }
}
