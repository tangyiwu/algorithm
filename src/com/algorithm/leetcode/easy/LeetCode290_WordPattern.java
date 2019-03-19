package com.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (!map.containsKey(patterns[i])) {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(patterns[i], strs[i]);
            } else {
                if (!map.get(patterns[i]).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode290_WordPattern wordPattern = new LeetCode290_WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
    }
}
