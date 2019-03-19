package com.algorithm.offer;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * 思路：对数组中所有的数字进行异或处理，结果就是这两个数字的异或结果diff，
 * diff中必有一位是1，表示这两个数字在这一位上，一个是0，一个是1，用这一位对数组进行分组，
 * 数组左边这一位全部是1，数组右边这一位全部是0，
 * 对数组左边进行异或处理，得到其中一个数字，对数组右边进行处理，得到另一个数字
 * 1,2,2,3,3,4
 * 1: 0001
 * 4: 0100
 * 1^4
 * 0101
 */
public class Problem56 {
    public void findTwoSingleNum(int[] a, int[] num1, int[] num2) {
        int diff = a[0];
        for (int i = 1; i < a.length; i++) {
            diff ^= a[i];
        }
        int high = 0;
        while (diff > 0) {
            diff >>= 1;
            high++;
        }
        int mask = (1 << (high - 1)); // mask = diff&(-diff)
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            if ((a[i] & mask) != 0) {
                num1[0] ^= a[i];
                i++;
                continue;
            }
            if ((a[j] & mask) == 0) {
                num2[0] ^= a[j];
                j--;
                continue;
            }
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    // 4 ^ 5
    // 0100
    // 0101
    // 0001
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 1, 2, 3, 5};
        int[] b = new int[1];
        int[] c = new int[1];
        Problem56 problem56 = new Problem56();
        problem56.findTwoSingleNum(a, b, c);
        System.out.println(b[0]);
        System.out.println(c[0]);
    }
}
