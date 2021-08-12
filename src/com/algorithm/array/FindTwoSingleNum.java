package com.algorithm.array;

import com.algorithm.sort.SortUtil;
import com.algorithm.utils.ArrayUtil;

/**
 * 有一个 n 个元素的数组，除了两个数只出现一次外，其余元素都出现两次，
 * 让你找出这两个只出现一次的数分别是几，要求时间复杂度为 O(n)
 * 且再开辟的内存空间固定(与 n 无关)。
 * <p>
 * 示例 :
 * 输入: [1,2,2,1,3,4]
 * 输出: [3,4]
 */
public class FindTwoSingleNum {
    private int xor(int[] a, int left, int right) {
        int xor = 0;
        while (left <= right) {
            xor = xor ^ a[left];
            left++;
        }
        return xor;
    }

    private int[] find(int[] a) {
        if (a.length <= 2) {
            return a;
        }
        int or = xor(a, 0, a.length - 1);

        int shift = 0;
        while ((or & 1) == 0) {
            shift++;
            or = or >> 1;
        }

        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (((a[i] >> shift) & 1) == 0) {
                i++;
            }
            while (((a[j] >> shift) & 1) == 1) {
                j--;
            }
            if (i < j) {
                SortUtil.swap(a, i, j);
            }
        }

        int[] result = new int[2];

        result[0] = xor(a, 0, i - 1);
        result[1] = xor(a, i, a.length - 1);

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 3, 4, 5, 6, 5, 6};
        int[] result = new FindTwoSingleNum().find(a);
        ArrayUtil.printArray(result);
    }
}
