package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

/**
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class LeetCode283_MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
        }
        int i = 0;
        int j = nums.length - zeros;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[i++] = nums[k];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        LeetCode283_MoveZeros moveZeros = new LeetCode283_MoveZeros();
        moveZeros.moveZeroes(a);
        ArrayUtil.printArray(a);
    }
}
