package com.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 */
public class LeetCode438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pChars = p.toCharArray();
        int[] a = new int[26];
        for (int i = p.length(); i <= s.length(); i++) {
            int hit = 0;
            for (char pc : pChars) {
                a[pc - 'a']++;
            }
            for (int j = i - p.length(); j < i; j++) {
                char cur = s.charAt(j);
                if (a[cur - 'a'] > 0) {
                    a[cur - 'a']--;
                    hit++;
                }
            }
            if (hit == p.length()) {
                result.add(i - p.length());
            } else {
                for (char pc : pChars) {
                    a[pc - 'a'] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode438_FindAnagrams findAnagrams = new LeetCode438_FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
    }
}
