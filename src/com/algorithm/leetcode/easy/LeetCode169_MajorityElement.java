package com.algorithm.leetcode.easy;

import java.util.Arrays;

public class LeetCode169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        int[] b = {2, 2, 1, 1, 1, 2, 2};
        LeetCode169_MajorityElement majorityElement = new LeetCode169_MajorityElement();
        System.out.println(majorityElement.majorityElement(a));
        System.out.println(majorityElement.majorityElement(b));
    }
}
