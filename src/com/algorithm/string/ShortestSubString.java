package com.algorithm.string;

public class ShortestSubString {
    public String minWindow(String source, String target) {
        if (source == null || source.length() <= 0) {
            return "";
        }
        int[] countSource = new int[128];
        int[] countTarget = new int[128];
        for (int i = 0; i < target.length(); i++) {
            countTarget[target.charAt(i)]++;
        }
        int begin = -1, end = source.length(), found = 0, minLen = source.length();
        for (int i = 0, start = i; i < source.length(); i++) {
            countSource[source.charAt(i)]++;
            if (countSource[source.charAt(i)] <= countTarget[source.charAt(i)]) {
                found++;
            }
            if (found == target.length()) {
                while (start < i && countSource[source.charAt(start)] > countTarget[source.charAt(start)]) {
                    countSource[source.charAt(start)]--;
                    start++;
                }
                if (i - start < minLen) {
                    minLen = i - start;
                    begin = start;
                    end = i;
                }
                countSource[source.charAt(start++)]--;
                found--;
            }
        }
        if (begin == -1) {
            return "";
        }
        return source.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        ShortestSubString subString = new ShortestSubString();
        System.out.println(subString.minWindow("ADOBECODEBANC", "ABC"));
    }
}
