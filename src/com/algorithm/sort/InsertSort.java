package com.algorithm.sort;

public class InsertSort {
    public void srot(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
