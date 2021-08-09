package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 */
public class InsertSort {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    SortUtil.swap(a, j, j-1);
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
