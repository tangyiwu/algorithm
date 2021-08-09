package com.algorithm.sort;

public class SortUtil {
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static int[] getArrayDemo() {
        int[] a = new int[]{6, 1, 27, 9, 3, 4, 5, 10, 8};
        return a;
    }

    public static void printArray(int[] a) {
        if (a == null) {
            return;
        }
        for (int e : a) {
            System.out.print(e + " ");
        }
    }
}
