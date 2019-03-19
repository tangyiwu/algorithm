package com.algorithm.leetcode.easy;

public class LeetCode168_ExcelSheetColumnTitle {
    /**
     * A=1
     * B=2
     * C=3
     * Z=26
     * AA=26+1  =27
     * AB=26+2  =28
     * AZ=1*26+26 =52
     * BA=2*26+1=53
     * BB=2*26+2=54
     * ZZ=26*26+26
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n -= 26;
            } else {
                sb.append((char) (n % 26 - 1 + 'A'));
            }
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode168_ExcelSheetColumnTitle columnTitle = new LeetCode168_ExcelSheetColumnTitle();
        System.out.println(columnTitle.convertToTitle(1));
        System.out.println(columnTitle.convertToTitle(2));
        System.out.println(columnTitle.convertToTitle(3));
        System.out.println(columnTitle.convertToTitle(26));
        System.out.println(columnTitle.convertToTitle(27));
        System.out.println(columnTitle.convertToTitle(28));
        System.out.println(columnTitle.convertToTitle(52));
        System.out.println(columnTitle.convertToTitle(100));
    }
}
