package com.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class LeetCode202_HappyNumber {
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, Set<Integer> set) {
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        if (sum == 1) {
            return true;
        }
        return isHappy(sum, set);
    }

    public static void main(String[] args) {
        LeetCode202_HappyNumber happyNumber = new LeetCode202_HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(20));
        System.out.println(happyNumber.isHappy(21));
    }
}
