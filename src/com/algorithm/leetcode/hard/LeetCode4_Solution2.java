package com.algorithm.leetcode.hard;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * </p>
 * <p>
 * 思路：利用指针将两个数组合并成一个数组
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(m+n)
 */
public class LeetCode4_Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int m = 0;
        int n = 0;
        while (i < nums.length) {
            if (m >= nums1.length) {
                nums[i] = nums2[n];
                n++;
            } else if (n >= nums2.length) {
                nums[i] = nums1[m];
                m++;
            } else {
                if (nums1[m] <= nums2[n]) {
                    nums[i] = nums1[m];
                    m++;
                } else {
                    nums[i] = nums2[n];
                    n++;
                }
            }
            i++;
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2f;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        LeetCode4_Solution2 solution2 = new LeetCode4_Solution2();
        System.out.println("中位数是：" + solution2.findMedianSortedArrays(nums1, nums2));
    }
}
