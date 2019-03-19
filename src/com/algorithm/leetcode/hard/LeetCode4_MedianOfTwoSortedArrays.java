package com.algorithm.leetcode.hard;

/**
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class LeetCode4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return median(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return median(nums1);
        }
        int[] merge = new int[nums1.length + nums2.length];
        merge(merge, nums1, nums2);
        return median(merge);
    }

    private double median(int[] nums) {
        if (nums.length % 2 == 1) {
            return nums[nums.length / 2];
        } else {
            int m = nums.length / 2;
            return (nums[m - 1] + nums[m]) / 2.0d;
        }
    }

    private void merge(int[] merge, int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = 0;
        while (n < merge.length) {
            if (i >= nums1.length) {
                merge[n++] = nums2[j++];
                continue;
            }
            if (j >= nums2.length) {
                merge[n++] = nums1[i++];
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                merge[n++] = nums1[i];
                i++;
            } else {
                merge[n++] = nums2[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        LeetCode4_MedianOfTwoSortedArrays demo = new LeetCode4_MedianOfTwoSortedArrays();
        System.out.println(demo.findMedianSortedArrays(a, b));
    }
}
