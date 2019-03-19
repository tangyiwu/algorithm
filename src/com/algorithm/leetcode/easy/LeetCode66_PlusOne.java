package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

/**
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * [9,9,9] -> [1,0,0,0]
 */
public class LeetCode66_PlusOne {
    public int[] plusOne(int[] digits) {
        int a = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = a + digits[i];
            digits[i] = sum % 10;
            a = sum / 10;
            if (a == 0) {
                break;
            }
        }
        if (a > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = a;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        LeetCode66_PlusOne plusOne = new LeetCode66_PlusOne();
        int[] digits = {1,2,3};
        ArrayUtil.printArray(plusOne.plusOne(digits));
        int[] newDigits = {9,9,9};
        ArrayUtil.printArray(plusOne.plusOne(newDigits));
    }
}
