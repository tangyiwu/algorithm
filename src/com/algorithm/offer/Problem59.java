package com.algorithm.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，
 * 他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class Problem59 {
    public ArrayList<Integer> slideWindowMax(int[] a, int windowSize) {
        if (a == null || windowSize < 1) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < windowSize; i++) {
            heap.add(a[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = windowSize; j < a.length; i++, j++) {
            heap.remove(a[i]);
            heap.add(a[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        Problem59 problem59 = new Problem59();
        ArrayList<Integer> ret = problem59.slideWindowMax(a, 3);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
}
