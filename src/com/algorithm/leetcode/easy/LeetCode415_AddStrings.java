package com.algorithm.leetcode.easy;

import java.util.Arrays;

public class LeetCode415_AddStrings {
    public String addStrings(String num1, String num2) {
        String longString = num1.length() > num2.length() ? num1 : num2;
        String shortString = num1.length() > num2.length() ? num2 : num1;
        char[] c = new char[longString.length() + 1];
        Arrays.fill(c, '0');
        return add(c, longString.toCharArray(), shortString.toCharArray());
    }

    private String add(char[] c, char[] bigNum, char[] smallNum) {
        int extra = 0;
        for (int i = 0; i < bigNum.length; i++) {
            char a = bigNum[bigNum.length - 1 - i];
            char b = '0';
            if (i < smallNum.length) {
                b = smallNum[smallNum.length - 1 - i];
            }
            int digitSum = (a - '0') + (b - '0') + extra;
            if (digitSum > 9) {
                extra = 1;
            } else {
                extra = 0;
            }
            c[c.length - 1 - i] = (char) ('0' + (digitSum % 10));
        }
        if (extra > 0) {
            c[0] = (char) ('0' + extra);
        }
        int offset = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') {
                offset++;
            } else {
                break;
            }
        }
        if (offset >= c.length) {
            return "0";
        }
        return String.valueOf(c, offset, c.length - offset);
    }

    public static void main(String[] args) {
        LeetCode415_AddStrings addStrings = new LeetCode415_AddStrings();
        System.out.println(addStrings.addStrings("123", "456"));
        System.out.println(addStrings.addStrings("234", "8889"));
        System.out.println(addStrings.addStrings("0", "8889"));
    }
}
