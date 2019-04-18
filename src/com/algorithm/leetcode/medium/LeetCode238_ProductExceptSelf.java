package com.algorithm.leetcode.medium;

import com.algorithm.utils.ArrayUtil;

/**
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * [a1, a2, a3, a4]
 * [1, a1, a1*a2, a1*a2*a3]
 * [a2*a3*a4, a3*a4, a4, 1]
 */
public class LeetCode238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int product = 1;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            ret[i] *= product;
            product *= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        LeetCode238_ProductExceptSelf productExceptSelf = new LeetCode238_ProductExceptSelf();
        int[] b = productExceptSelf.productExceptSelf(a);
        ArrayUtil.printArray(b);
    }
}
