package com.algorithm.leetcode.easy;


/**
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 */
public class LeetCode38_CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        String s = "1";

        while (n > 1) {
            int count = 1;
            char lastChar = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == lastChar) count++;
                else {
                    sb.append(count).append(lastChar);
                    count = 1;
                    lastChar = s.charAt(i);
                }
            }
            sb.append(count).append(lastChar);
            s = sb.toString();
            sb.setLength(0);
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode38_CountAndSay countAndSay = new LeetCode38_CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
        System.out.println(countAndSay.countAndSay(7));
        System.out.println(countAndSay.countAndSay(10));
        System.out.println(countAndSay.countAndSay(30));
    }
}
