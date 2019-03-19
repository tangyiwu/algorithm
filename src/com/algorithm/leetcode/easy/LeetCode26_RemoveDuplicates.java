package com.algorithm.leetcode.easy;

/**
 * Remove Duplicates from Sorted Array
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class LeetCode26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int count = 1;
        int check = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != check) {
                count++;
                check = nums[i];
            }
        }
        check = nums[0];
        int i = 1;
        int j = 1;
        for (; i < count; i++) {
            for (; j < nums.length; j++) {
                if (nums[j] != check) {
                    check = nums[j];
                    nums[i] = check;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode26_RemoveDuplicates removeDuplicates = new LeetCode26_RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
