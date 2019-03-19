package com.algorithm.leetcode.easy;

public class LeetCode303_NumArray {
    private static class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if (i <= j && this.nums != null) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += this.nums[k];
                }
                return sum;
            }
            return 0;
        }
    }
}
