package com.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void sort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int cursor = a[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (a[j] >= cursor && i < j) {
                j--;
            }
            while (a[i] <= cursor && i < j) {
                i++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[left] = a[i];
        a[i] = cursor;
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }

    public static void main(String[] args) {
        int[] a = SortUtil.getArrayDemo();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        SortUtil.printArray(a);
    }
}
