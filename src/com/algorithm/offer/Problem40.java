package com.algorithm.offer;

import java.util.PriorityQueue;

/**
 * 最小的 K 个数
 */
public class Problem40 {
    public int[] minK(int[] a, int k) {
        if (k <= 0 || k > a.length) {
            return null;
        }
        int[] r = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int i = queue.size();
        while (!queue.isEmpty()) {
            r[--i] = queue.poll();
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 9, 8, 4, 5, 10, 6, 3};
        int[] minK = new Problem40().minK(a, 5);
        for (int i = 0; i < minK.length; i++) {
            System.out.print(minK[i] + " ");
        }
    }
}
