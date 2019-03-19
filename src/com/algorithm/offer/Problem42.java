package com.algorithm.offer;


/**
 * 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class Problem42 {
    public int maxSumSub(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            int sum = findMax(a, 0, i);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    private int findMax(int[] a, int sum, int p) {
        if (p == a.length - 1) {
            if (a[p] <= 0) {
                return sum;
            }
            return sum + a[p];
        }
        int postSum = findMax(a, sum + a[p], p + 1);
        if (sum >= postSum) {
            return sum;
        }
        return postSum;
    }

    public static void main(String[] args) {
        int[] a = {6, -3, -2, 7, -15, 1, 2, 2};
        Problem42 problem42 = new Problem42();
        System.out.println(problem42.maxSumSub(a));
    }
}
