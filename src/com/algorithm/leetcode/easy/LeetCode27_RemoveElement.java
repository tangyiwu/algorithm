package com.algorithm.leetcode.easy;

/**
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class LeetCode27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        LeetCode27_RemoveElement removeElement = new LeetCode27_RemoveElement();
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        int left = removeElement.removeElement(a, 2);
        System.out.println(left);
    }
}
