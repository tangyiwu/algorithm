package com.algorithm.leetcode.medium;

public class LeetCode152_MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int p = nums[0];
        dpMax[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            if(dpMax[i] > p) {
                p = dpMax[i];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        LeetCode152_MaxProduct demo = new LeetCode152_MaxProduct();
        int[] a = {-2,1, 2,0,3,5,-2,-3,-5,10,-2};
        System.out.println(demo.maxProduct(a));
    }
}
