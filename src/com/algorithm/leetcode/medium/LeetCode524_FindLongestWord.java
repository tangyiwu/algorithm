package com.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 */
public class LeetCode524_FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.isEmpty()) {
            return "";
        }
        List<String> solutions = new ArrayList<>();
        for (String item : d) {
            int i = 0;
            int j = 0;
            int hit = 0;
            while (i < s.length() && j < item.length()) {
                if (s.charAt(i) != item.charAt(j)) {
                    i++;
                    continue;
                }
                i++;
                j++;
                hit++;
            }
            if (hit == item.length()) {
                solutions.add(item);
            }
        }
        if (!solutions.isEmpty()) {
            Collections.sort(solutions, (o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            });
            return solutions.get(0);
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
