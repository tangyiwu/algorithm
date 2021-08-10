package com.algorithm.leetcode.easy;

public class LeetCode136_SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        while (i < nums.length) {
            xor = xor ^ nums[i];
            i++;
        }
        return xor;
    }

    public static void main(String[] args) {
        LeetCode136_SingleNumber singleNumber = new LeetCode136_SingleNumber();
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber.singleNumber(nums));
        int[] numss = {4,1,2,1,2};
        System.out.println(singleNumber.singleNumber(numss));
    }
}
