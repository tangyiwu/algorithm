package com.algorithm.leetcode.easy;

public class LeetCode405_ToHex {
    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode405_ToHex toHex = new LeetCode405_ToHex();
        System.out.println(toHex.toHex(0));
        System.out.println(toHex.toHex(26));
        System.out.println(toHex.toHex(-1));
        System.out.println(toHex.toHex(-2));
//        System.out.println(toHex.toHex(2));
//        System.out.println(toHex.toHex(Integer.MAX_VALUE));
//        System.out.println(toHex.toHex(Integer.MIN_VALUE));
    }
}
