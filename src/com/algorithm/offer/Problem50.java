package com.algorithm.offer;

/**
 * 第一个只出现一次的字符位置
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * eg:
 * input: abcbcaeddb
 * output: e
 */
public class Problem50 {
    char e;

    public int firstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        int[] chars = new int[256];
        for (char c : str.toCharArray()) {
            chars[str.indexOf(c)]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1) {
                e = str.charAt(i);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem50 problem50 = new Problem50();
        System.out.println(problem50.firstNotRepeatingChar("abcbcaeddb"));
        System.out.println(problem50.e);
    }
}
