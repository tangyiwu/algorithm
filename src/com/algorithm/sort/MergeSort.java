package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 归并排序
 */
public class MergeSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            sort(a, left, m);
            sort(a, m + 1, right);
            merge(a, left, m, right);
        }
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= middle) {
            tmp[k++] = a[i++];
        }
        while (j <= right) {
            tmp[k++] = a[j++];
        }
        for (int index = 0; index < k; index++) {
            a[left + index] = tmp[index];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        mergeSort.sort(a);
        ArrayUtil.printArray(a);
    }
}
