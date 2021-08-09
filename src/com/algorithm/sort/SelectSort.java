package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 */
public class SelectSort {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortUtil.swap(a, i, minIndex);
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
