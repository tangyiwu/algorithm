package com.algorithm.leetcode.easy;

public class LeetCode58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int lastStart = -1;
        int lastEnd = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && lastEnd < 0) {
                lastEnd = i;
                continue;
            }
            if (lastEnd < 0) {
                continue;
            }
            if (s.charAt(i) == ' ') {
                lastStart = i;
                break;
            }
        }
        if (lastEnd >= 0) {
            return lastEnd - lastStart;
        }

        return 0;
    }

    public static void main(String[] args) {
        LeetCode58_LengthOfLastWord lengthOfLastWord = new LeetCode58_LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord.lengthOfLastWord(" hello"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("hello"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("a "));
    }
}
