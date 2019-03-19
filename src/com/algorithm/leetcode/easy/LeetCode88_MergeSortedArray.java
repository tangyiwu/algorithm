package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

public class LeetCode88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
//        Arrays.sort(nums1);
        quickSort(nums1, 0, m + n - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int cursor = nums[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (nums[j] >= cursor && i < j) {
                j--;
            }
            while (nums[i] <= cursor && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        nums[left] = nums[i];
        nums[i] = cursor;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        LeetCode88_MergeSortedArray mergeSortedArray = new LeetCode88_MergeSortedArray();
        mergeSortedArray.merge(num1, 3, num2, 3);
        ArrayUtil.printArray(num1);
    }
}
