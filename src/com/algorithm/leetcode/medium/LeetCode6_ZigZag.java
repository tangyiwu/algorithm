package com.algorithm.leetcode.medium;

public class LeetCode6_ZigZag {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] lines = new StringBuilder[numRows];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new StringBuilder();
        }
        boolean towardBottom = true;
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lines[y].append(c);
            if (towardBottom) {
                if (y == numRows - 1) {
                    towardBottom = false;
                    y--;
                    x++;
                } else {
                    y++;
                }
            } else {
                if (y == 0) {
                    towardBottom = true;
                    y++;
                } else {
                    y--;
                    x++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode6_ZigZag zigZag = new LeetCode6_ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 1));//PAYPALISHIRING
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));//PAHNAPLSIIGYIR
        System.out.println(zigZag.convert("PAYPALISHIRING", 4));//PINALSIGYAHRPI
    }
}
