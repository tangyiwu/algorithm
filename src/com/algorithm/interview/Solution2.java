package com.algorithm.interview;

import java.util.Random;

public class Solution2 {
    /**
     * [1,3,-3] => 6
     * [-8,4,0,5,-3,6] => 14
     * [1,2,3,4,5] =>10
     */
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0] * 2;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                int appeal = A[i] + A[j] + (i - j);
                max = Math.max(max, appeal);
            }
        }
        return max;
    }

    public int solution2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0] * 2;
        int[] maxPos = new int[2];
        for (int i = 1; i < A.length; i++) {
            int a = A[i] + A[maxPos[0]] + (i - maxPos[0]);
            int b = A[i] + A[maxPos[1]] + (i - maxPos[1]);
            int c = A[i] * 2;
            int m = Math.max(a, Math.max(b, c));
            if (m > max) {
                max = m;
                if (max == a) {
                    maxPos[1] = i;
                } else if (max == b) {
                    maxPos[0] = maxPos[1];
                    maxPos[1] = i;
                } else {
                    maxPos[0] = i;
                    maxPos[1] = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -3};
        int[] b = {-8, 4, 0, 5, -3, 6};
        int[] c = {-1, 23, 43, 2, 3, 4, 1, -234, 23, 54, 234, 446, 324, -324, 134, 123, 23, 3, 234, 4, 3, 2, 3, 4, 3, 23, 4, 34, 43, 43, -324, 342234, -32441, 234, 4324, 53234};
        Random random = new Random();
        int[] d = new int[100000];
        for (int i = 0; i < d.length; i++) {
            d[i] = random.nextInt();
        }
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(a));
        System.out.println(solution2.solution2(a));
        System.out.println(solution2.solution(b));
        System.out.println(solution2.solution2(b));
        System.out.println(solution2.solution(c));
        System.out.println(solution2.solution2(c));
        System.out.println(solution2.solution2(d));
    }
}
