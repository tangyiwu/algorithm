package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

public class ShellSort {
    public void sort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int d = a.length;
        while (true) {
            d /= 2;
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < a.length; j += d) {
                    //插入排序
                    for (int k = j; k >= d; k -= d) {
                        if (a[k] < a[k - d]) {
                            swap(a, k, k - d);
                        }
                    }
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        shellSort.sort(a);
        ArrayUtil.printArray(a);
    }
}
