package com.algorithm.sort;

import com.algorithm.utils.ArrayUtil;

/**
 * 基数排序
 * 时间复杂度O(d(n+radix)) // d表示需要分配和收集的次数，是数字的最大长度，如非负数组最大数字为999，d就是3，radix表示基数大小，数组中数字都是非负数，radix是10，考虑到负数，radix是20
 * 空间复杂度O(n*radix+n) // 需要一个二维数组记录每次分配结果，空间复杂度O(n*radix)，需要一个数组在每次分配和收集过程中，基数命中元素个数，空间复杂度O(n)
 */
public class RadixSort {
    public void sort(int[] a) {
        int d = getMaxDigit(a);
        int base = 1;
        //0..9记录负数, 10..19记录非负数(>=0)
        int[] count = new int[20];
        //桶
        int[][] bucket = new int[20][a.length];
        for (int i = 0; i < d; i++) {
            for (int check : a) {
                int digit = check / base % 10;
                digit += 10;
                bucket[digit][count[digit]] = check;
                count[digit]++;
            }
            int k = 0;
            for (int j = 0; j < 20; j++) {
                if (count[j] > 0) {
                    for (int c = 0; c < count[j]; c++) {
                        a[k++] = bucket[j][c];
                    }
                    count[j] = 0;
                }
            }
            base *= 10;
        }
    }

    private int getMaxDigit(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.max(min, a[i]);
        }
        if (max < 0) {
            return getDigits(min);
        }
        if (min > 0) {
            return getDigits(max);
        }
        int len1 = getDigits(max);
        int len2 = getDigits(min);
        return Math.max(len1, len2);
    }

    private int getDigits(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] a = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        int[] b = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        int[] c = {1, 23, 523, 234, -34, -453, 34, 53, 34, -45, 353, 67};
        radixSort.sort(a);
        radixSort.sort(b);
        radixSort.sort(c);
        ArrayUtil.printArray(a);
        ArrayUtil.printArray(b);
        ArrayUtil.printArray(c);
    }
}
