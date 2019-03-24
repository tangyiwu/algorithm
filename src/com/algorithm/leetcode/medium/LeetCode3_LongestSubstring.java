package com.algorithm.leetcode.medium;

import java.util.*;

public class LeetCode3_LongestSubstring {
    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        int longest = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int preIndex = map.get(c);
                if (preIndex < i - dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = i - preIndex;
                }
            }
            map.put(c, i);
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int anw = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = -1, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            i = Math.max(map.getOrDefault(c, -1), i);
            anw = Math.max(anw, j - i);
            map.put(c, j);
        }
        return anw;
    }

    public static void main(String[] args) {
        LeetCode3_LongestSubstring longestSubstring = new LeetCode3_LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(longestSubstring.lengthOfLongestSubstring2("abc"));
    }
}
