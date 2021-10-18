package com.algorithm.leetcode.hard;

public class LeetCode4_Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findKthMin(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 1) / 2) + findKthMin(nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 2) / 2)) * 0.5;
    }

    private double findKthMin(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        if (len1 > len2) {
            return findKthMin(nums2, s2, e2, nums1, s1, e1, k);
        }
        if (len1 == 0) {
            return nums2[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int i = s1 + Math.min(k / 2, len1) - 1;
        int j = s2 + Math.min(k / 2, len2) - 1;
        if (nums1[i] < nums2[j]) {
            return findKthMin(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        } else {
            return findKthMin(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        LeetCode4_Solution3 solution3 = new LeetCode4_Solution3();
        System.out.println("中位数是：" + solution3.findMedianSortedArrays(nums1, nums2));
    }
}
