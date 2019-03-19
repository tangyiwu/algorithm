package com.algorithm.leetcode.easy;

/**
 * 字符串最长的共同前缀
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class LeetCode14_LongestCommonPrefix {
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        boolean isOdd = strs.length % 2 == 1;
        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            int c = strs[0].charAt(i) - 'a';
            int cXor = c;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return end > 0 ? strs[0].substring(0, end) : "";
                }
                cXor ^= strs[j].charAt(i) - 'a';
            }
            if (!isOdd) {
                if (cXor == 0) {
                    end++;
                } else {
                    break;
                }
            } else {
                if (cXor == c) {
                    end++;
                } else {
                    break;
                }
            }
        }
        return end > 0 ? strs[0].substring(0, end) : "";
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean hit = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    hit = false;
                    break;
                }
            }
            if (hit) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LeetCode14_LongestCommonPrefix longestCommonPrefix = new LeetCode14_LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
        String[] abc = {"aa", "a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix2(abc));
    }
}
