package com.algorithm.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class Problem21 {
    public void reOrderArray(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        int oddCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                oddCount++;
            }
        }
        int i = 0;
        while (i < oddCount) {
            if (a[i] % 2 == 1) {
                i++;
                continue;
            }
            int nearOddPos = nearOddPos(i, a);
            if (nearOddPos == i) {
                break;
            }
            bubbleMove(a, nearOddPos, i++, -1);
        }
    }

    private int nearOddPos(int start, int[] a) {
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                return i;
            }
        }
        return start;
    }

    private void bubbleMove(int[] a, int from, int to, int step) {
        if (from == to) {
            return;
        }
        swap(a, from, from + step);
        bubbleMove(a, from + step, to, step);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Problem21 problem21 = new Problem21();
        problem21.reOrderArray(a);
        System.out.println(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
