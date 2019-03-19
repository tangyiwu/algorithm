package com.algorithm.offer;

/**
 * 构建乘积数组
 * <p>
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 */
public class Problem66 {
    /**
     * A: [1, 2, 3, 4, 5]
     * first loop: from left to right
     * B: [1, 1, 2, 6, 12]
     * second loop: from right to left
     * B: [1, 1, 2, 6, 12*1]
     * B: [1, 1, 2, 6*1*5, 12]
     * B: [1, 1, 2*1*5*4, 30, 12]
     * B: [1, 1*1*5*4*3, 40, 30, 12]
     * B: [1*1*5*4*3*2, 60, 40, 30, 12]
     * =>
     * B: [120, 60, 40, 30, 12]
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0, product = 1; i < A.length; product *= A[i], i++) {
            B[i] = product;
        }
        for (int i = A.length - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }

    public static void main(String[] args) {
        Problem66 problem66 = new Problem66();
        int[] b = problem66.multiply(new int[]{1, 2, 3, 4, 5});
    }
}
