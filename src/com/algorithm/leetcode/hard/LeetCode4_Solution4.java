package com.algorithm.leetcode.hard;

public class LeetCode4_Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // [1, 3]
        // [2, 7]
        if (((m + n) % 2) == 0) {
            double a = findKthMin2(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2);
            double b = findKthMin2(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);
            return (a + b) / 2;
        } else {
            return findKthMin(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);
        }
    }

    /**
     * 递归思路
     */
    private double findKthMin(
            int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        if (left1 > right1) {
            return nums2[left2 + k - 1];
        } else if (left2 > right2) {
            return nums1[left1 + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        int step = k / 2;
        int p1 = Math.min(left1 + step - 1, right1);
        int p2 = Math.min(left2 + step - 1, right2);
        if (nums1[p1] < nums2[p2]) {
            return findKthMin(nums1, p1 + 1, right1, nums2, left2, right2, k - (p1 - left1 + 1));
        } else {
            return findKthMin(nums1, left1, right1, nums2, p2 + 1, right2, k - (p2 - left2 + 1));
        }
    }

    /**
     * 非递归思路
     */
    private double findKthMin2(
            int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        while (left1 <= right1 || left2 <= right2) {
            if (left1 > right1) {
                return nums2[left2 + k - 1];
            }
            if (left2 > right2) {
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                break;
            }
            int step = k / 2;
            int p1 = Math.min(left1 + step - 1, right1);
            int p2 = Math.min(left2 + step - 1, right2);
            if (nums1[p1] < nums2[p2]) {
                k -= (p1 - left1 + 1);
                left1 = p1 + 1;
            } else {
                k -= (p2 - left2 + 1);
                left2 = p2 + 1;
            }
        }
        return Math.min(nums1[left1], nums2[left2]);
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 7};
        LeetCode4_Solution4 solution4 = new LeetCode4_Solution4();
        double m = solution4.findMedianSortedArrays(a, b);
        System.out.println("median is " + m);
    }
}
