package com.algorithm.sort;

public class ShellSort {
    public void sort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int tmp = 0;
        int incre = a.length;
        while (true) {
            incre /= 2;
            for (int k = 0; k < incre; k++) {
                for (int i = k + incre; i < a.length; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        if (a[j] > a[j - incre]) {
                            tmp = a[j - incre];
                            a[j - incre] = a[j];
                            a[j] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }
}
