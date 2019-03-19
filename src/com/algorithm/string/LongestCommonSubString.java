package com.algorithm.string;

public class LongestCommonSubString {
    public String longestCommonSubString(String str1, String str2) {
        char[] strings1 = str1.toCharArray();
        char[] strings2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] matrix = new int[len1][len2];
        int longestLength = 0;
        int x = 0, y = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (strings1[i] == strings2[j]) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > longestLength) {
                        longestLength = matrix[i][j];
                        x = i;
                        y = j;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        char[] subStrings = new char[longestLength];
        for (int i = 0; i < longestLength; i++) {
            subStrings[longestLength - 1 - i] = strings1[x - i];
        }
        return String.valueOf(subStrings);
    }

    public static void main(String[] args) {
        LongestCommonSubString commonSubString = new LongestCommonSubString();
        System.out.println(commonSubString.longestCommonSubString("babcd", "cabcaef"));
    }
}
