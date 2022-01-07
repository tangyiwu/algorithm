package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 */
public class QuickSort {
    public void sort(int[] a, int left, int right) {
        if (left < right) {
            int m = partition(a, left, right);
            sort(a, left, m - 1);
            sort(a, m + 1, right);
        }
    }

    private int partition(int[] a, int left, int right) {
        int cursor = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && a[j] >= cursor) {
                j--;
            }
            while (i < j && a[i] <= cursor) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, left, i);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {-1, 5, 3, 4, 0};
        ArrayUtil.printArray(a);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        ArrayUtil.printArray(a);
    }
}
