package com.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true
public class LeetCode205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (set.contains(tc)) {
                    return false;
                }
                map.put(sc, tc);
                set.add(tc);
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i)] != a[t.charAt(i) + 256]) {
                return false;
            }
            a[s.charAt(i)] = a[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode205IsomorphicStrings isomorphicStrings = new LeetCode205IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("ab", "aa"));
        System.out.println(isomorphicStrings.isIsomorphic2("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic2("ab", "aa"));
        System.out.println(isomorphicStrings.isIsomorphic2("a", "a"));
        System.out.println(isomorphicStrings.isIsomorphic2("ab", "abc"));
    }
}
