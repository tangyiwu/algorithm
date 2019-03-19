package com.algorithm.leetcode.easy;

/**
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class LeetCode67_AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.equals("")) {
            return b;
        }
        if (b == null || b.equals("")) {
            return a;
        }
        int handleDigits = 0;
        int round = 0;
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder sb = new StringBuilder();
        while (handleDigits < a.length() || handleDigits < b.length()) {
            int aDigit = 0;
            int bDigit = 0;
            if (handleDigits < a.length()) {
                aDigit = a.charAt(aLen - 1 - handleDigits) - '0';
            }
            if (handleDigits < b.length()) {
                bDigit = b.charAt(bLen - 1 - handleDigits) - '0';
            }
            int sum = aDigit + bDigit + round;
            sb.insert(0, sum % 2);
            round = sum / 2;
            handleDigits++;
        }
        if (round > 0) {
            sb.insert(0, round);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode67_AddBinary addBinary = new LeetCode67_AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
