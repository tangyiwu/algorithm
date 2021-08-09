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
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && a[i] <= cursor) {
                i++;
            }
            while (i <= j && a[j] >= cursor) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        a[left] = a[j];
        a[j] = cursor;
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = SortUtil.getArrayDemo();
        ArrayUtil.printArray(a);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        ArrayUtil.printArray(a);
    }
}
