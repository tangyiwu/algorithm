package com.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class LeetCode13_RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> symbolValueMap = new HashMap<>();
        symbolValueMap.put('I', 1);
        symbolValueMap.put('V', 5);
        symbolValueMap.put('X', 10);
        symbolValueMap.put('L', 50);
        symbolValueMap.put('C', 100);
        symbolValueMap.put('D', 500);
        symbolValueMap.put('M', 1000);
        Map<Character, Integer> symbolPosMap = new HashMap<>();
        symbolPosMap.put('I', 0);
        symbolPosMap.put('V', 1);
        symbolPosMap.put('X', 2);
        symbolPosMap.put('L', 3);
        symbolPosMap.put('C', 4);
        symbolPosMap.put('D', 5);
        symbolPosMap.put('M', 6);
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            num += symbolValueMap.get(chars[i]);
            if (i > 0) {
                int curPos = symbolPosMap.get(chars[i]);
                int prePos = symbolPosMap.get(chars[i - 1]);
                if (curPos > prePos && curPos - prePos <= 2) {
                    num -= 2 * symbolValueMap.get(chars[i - 1]);
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode13_RomanToInteger romanToInteger = new LeetCode13_RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));//3
        System.out.println(romanToInteger.romanToInt("IV"));//4
        System.out.println(romanToInteger.romanToInt("IX"));//9
        System.out.println(romanToInteger.romanToInt("LVIII"));//58
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));//1994
    }
}
