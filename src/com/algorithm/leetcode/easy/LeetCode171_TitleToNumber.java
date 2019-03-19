package com.algorithm.leetcode.easy;

public class LeetCode171_TitleToNumber {
    /**
     * ABC = A*26*26 + B*26 + C = 1*26*26+2*26+3
     */
    public int titleToNumber(String s) {
        int num = 0;
        while (s.length() > 0) {
            if (s.length() == 1) {
                num = num + (s.charAt(0) - 'A' + 1);
            } else {
                num = (s.charAt(0) - 'A' + 1 + num) * 26;
            }
            s = s.substring(1);
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode171_TitleToNumber titleToNumber = new LeetCode171_TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("A"));
        System.out.println(titleToNumber.titleToNumber("B"));
        System.out.println(titleToNumber.titleToNumber("C"));
        System.out.println(titleToNumber.titleToNumber("Z"));
        System.out.println(titleToNumber.titleToNumber("AA"));
        System.out.println(titleToNumber.titleToNumber("AB"));
        System.out.println(titleToNumber.titleToNumber("AC"));
        System.out.println(titleToNumber.titleToNumber("AD"));
        System.out.println(titleToNumber.titleToNumber("ZA"));
    }
}
