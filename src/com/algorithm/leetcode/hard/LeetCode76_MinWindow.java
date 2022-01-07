package com.algorithm.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76_MinWindow {
    Map<Character, Integer> sourceMap = new HashMap<>();
    Map<Character, Integer> targetMap = new HashMap<>();

    public String minWindow(String s, String t) {
        for (char c : t.toCharArray()) {
            if (targetMap.containsKey(c)) {
                targetMap.put(c, targetMap.get(c) + 1);
            } else {
                targetMap.put(c, 1);
            }
        }
        int left = 0, right = 0;
        String min = null;
        String tmp;
        while (right <= s.length()) {
            while (isMatch()) {
                tmp = s.substring(left, right);
                if (min == null) {
                    min = tmp;
                } else if (tmp.length() < min.length()) {
                    min = tmp;
                }
                Character leftChar = s.charAt(left);
                if (sourceMap.containsKey(leftChar)) {
                    sourceMap.put(leftChar, sourceMap.get(leftChar) - 1);
                }
                left++;
            }
            if (right >= s.length()) {
                break;
            }
            Character rightChar = s.charAt(right);
            if (targetMap.containsKey(rightChar)) {
                if (sourceMap.containsKey(rightChar)) {
                    sourceMap.put(rightChar, sourceMap.get(rightChar) + 1);
                } else {
                    sourceMap.put(rightChar, 1);
                }
            }
            right++;
        }
        if (min != null) return min;

        return "";
    }

    private boolean isMatch() {
        for (Character c : targetMap.keySet()) {
            if (!sourceMap.containsKey(c) || sourceMap.get(c) < targetMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode76_MinWindow solution = new LeetCode76_MinWindow();
        String ans = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }
}
