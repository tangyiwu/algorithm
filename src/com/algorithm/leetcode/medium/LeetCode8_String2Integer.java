package com.algorithm.leetcode.medium;

public class LeetCode8_String2Integer {
    public int myAtoi(String str) {
        boolean isNegative = false;
        int absNum = 0;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                if (i == 0) {
                    isNegative = true;
                    continue;
                } else {
                    break;
                }
            }
            if (c == '+') {
                if (i == 0) {
                    continue;
                } else {
                    break;
                }
            }
            if (c >= '0' && c <= '9') {
                int digit = c - '0';
                if (!isNegative) {
                    if ((Integer.MAX_VALUE - digit) / 10 < absNum) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if ((1L + Integer.MAX_VALUE - digit) / 10 < absNum) {
                        return Integer.MIN_VALUE;
                    }
                }
                absNum = absNum * 10 + digit;
                continue;
            }
            break;
        }
        return isNegative ? -absNum : absNum;
    }

    public static void main(String[] args) {
        LeetCode8_String2Integer string2Integer = new LeetCode8_String2Integer();
        System.out.println(string2Integer.myAtoi("42"));
        System.out.println(string2Integer.myAtoi("  -42"));
        System.out.println(string2Integer.myAtoi("4193 with words"));
        System.out.println(string2Integer.myAtoi("words and 987"));
        System.out.println(string2Integer.myAtoi("-91283472332"));
        System.out.println(string2Integer.myAtoi("9223372036854775808"));
        System.out.println(string2Integer.myAtoi("-000000000000001"));

        System.out.println(string2Integer.myAtoi("2147483646"));
        System.out.println(string2Integer.myAtoi("2147483647"));
        System.out.println(string2Integer.myAtoi("2147483648"));

        System.out.println(string2Integer.myAtoi("-2147483649"));
        System.out.println(string2Integer.myAtoi("-2147483648"));
        System.out.println(string2Integer.myAtoi("-2147483647"));
    }
}
