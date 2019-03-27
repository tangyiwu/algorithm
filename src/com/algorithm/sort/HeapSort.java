package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;
import com.sun.istack.internal.NotNull;

import java.util.Comparator;

/**
 * 队排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class HeapSort {
    private Comparator<Integer> comparator;

    public HeapSort() {
        this(DEFAULT_COMPARATOR);
    }

    public HeapSort(@NotNull Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    private static final Comparator<Integer> DEFAULT_COMPARATOR = Comparator.comparingInt(o -> o);

    public void heapify(int[] a, int index, int heapSize) {
        int left, right, iMax;
        while (true) {
            iMax = index;
            left = 2 * index + 1;
            right = 2 * index + 2;
            if (left < heapSize && comparator.compare(a[iMax], a[left]) < 0) {
                iMax = left;
            }
            if (right < a.length && comparator.compare(a[iMax], a[right]) < 0) {
                iMax = right;
            }
            if (iMax != index) {
                swap(a, iMax, index);
                index = iMax;
            } else {
                break;
            }
        }
    }

    public void buildHeap(int[] a) {
        int heapSize = a.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(a, i, heapSize);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.buildHeap(a);
        ArrayUtil.printArray(a);
    }
}
