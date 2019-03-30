package com.algorithm.leetcode.medium;

public class LeetCode5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int[] pos = new int[2];
        for (int i = 0; i < s.length() - 1; i++) {
            int len = findPalindromLength(s, i, i);
            if (len > pos[1] - pos[0] + 1) {
                pos[0] = i - len / 2;
                pos[1] = i + len / 2;
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                len = findPalindromLength(s, i, i + 1);
                if (len > pos[1] - pos[0] + 1) {
                    pos[0] = i + 1 - len / 2;
                    pos[1] = pos[0] + len - 1;
                }
            }
        }
        return s.substring(pos[0], pos[1] + 1);
    }

    private int findPalindromLength(String s, int i, int j) {
        int len = j - i + 1;
        while (i > 0 && j < s.length() - 1) {
            i--;
            j++;
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            len += 2;
        }
        return len;
    }

    /**
     * 动态规划
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j - i == 0) || (j - i == 1) || (j >= i + 2 && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LeetCode5_LongestPalindromicSubstring palindromicSubstring = new LeetCode5_LongestPalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome("babad"));
        System.out.println(palindromicSubstring.longestPalindrome2("babad"));
        System.out.println(palindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(palindromicSubstring.longestPalindrome2("cbbd"));
    }
}
