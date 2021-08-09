package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 冒泡排序
 * 时间复杂度 O(n^2)
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtil.swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
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
