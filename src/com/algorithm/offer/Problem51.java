package com.algorithm.offer;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 12321 => (32, 31, 21, 21)
 */
public class Problem51 {
    private int cnt;
    private int[] tmp;

    /**
     * O(n^2)
     */
    public int findReversePairCount(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int reverseOrderCount(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }
        cnt = 0;
        tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1);
        return cnt;
    }

    private void mergeSort(int[] a, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    /**
     * 1 2 3 2
     * <p>
     * 1 2 2 3
     * i   j
     * k
     */
    private void merge(int[] a, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m || j <= r) {
            if (i > m) {
                tmp[k++] = a[j++];
            } else if (j > r) {
                tmp[k++] = a[i++];
            } else if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
                cnt += m - i + 1;
            }
        }
        for (k = l; k <= r; k++) {
            a[k] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        Problem51 problem51 = new Problem51();
        System.out.println(problem51.findReversePairCount(a));
        System.out.println(problem51.reverseOrderCount(a));
    }
}
