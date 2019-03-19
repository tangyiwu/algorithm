package com.algorithm.leetcode.easy;

public class LeetCode268_MissingNumber {
    public int missingNumber(int[] nums) {
        int[] a = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]]++;
        }
        for (int j = 0; j < a.length; j++) {
            if (a[j] == 0) {
                return j;
            }
        }
        return -1;
    }
}
