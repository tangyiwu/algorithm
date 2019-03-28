package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 冒泡排序
 * 时间复杂度 O(n2)
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int tmp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
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
