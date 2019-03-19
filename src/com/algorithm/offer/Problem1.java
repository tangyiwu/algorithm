package com.algorithm.offer;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 */
public class Problem1 {
    public boolean duplicate(int[] a) {
        if (a == null || a.length <= 0) {
            return false;
        }
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int e = a[i];
            b[e]++;
            if (b[e] > 1) {
                System.out.println(e);
                return true;
            }
        }
        return false;
    }

    public boolean duplicate2(int[] a) {
        if (a == null || a.length <= 0) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            int ie = a[i];
            while (true) {
                if (ie == i) {
                    break;
                }
                int temp = a[ie];
                if (ie == temp) {
                    System.out.println(ie);
                    return true;
                }
                a[ie] = a[i];
                a[i] = ie = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 0, 2, 5};
        Problem1 problem1 = new Problem1();
        problem1.duplicate(a);
        problem1.duplicate2(a);
    }
}
