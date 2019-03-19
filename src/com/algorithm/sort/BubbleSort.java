package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i + 1; j--) {
                if (nums[j] < nums[j - 1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = SortUtil.getArrayDemo();
        ArrayUtil.printArray(nums);
        sort(nums);
        ArrayUtil.printArray(nums);
    }
}
