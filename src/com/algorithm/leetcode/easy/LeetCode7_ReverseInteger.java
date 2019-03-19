package com.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 */
public class LeetCode7_ReverseInteger {
    public static int reverseInteger(int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!isNegative) {
                if (result * 10L + list.get(i) > Integer.MAX_VALUE) {
                    return 0;
                }
            } else {
                if (result * 10L + list.get(i) > Integer.MIN_VALUE * (-1L)) {
                    return 0;
                }
            }
            result = result * 10 + list.get(i);
        }
        if (isNegative) {
            result = -result;
        }
        return result;
    }

    public static int reverseInteger2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(120));
        System.out.println(reverseInteger(1534236469));
        System.out.println(reverseInteger2(-123));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE % 10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE % 10);
    }
}
