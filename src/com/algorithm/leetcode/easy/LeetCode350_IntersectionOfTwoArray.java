package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * * 1 2 3 1
 * 2
 * 3
 */
public class LeetCode350_IntersectionOfTwoArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] a = new int[list.size()];
        for (int k = 0; k < a.length; k++) {
            a[k] = list.get(k);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        LeetCode350_IntersectionOfTwoArray intersectionOfTwoArray = new LeetCode350_IntersectionOfTwoArray();
        ArrayUtil.printArray(intersectionOfTwoArray.intersect(a, b));
        int[] c = {4, 9, 5};
        int[] d = {9, 4, 9, 8, 4};
        ArrayUtil.printArray(intersectionOfTwoArray.intersect(c, d));
        int[] e = {1, 2};
        int[] f = {2, 1};
        ArrayUtil.printArray(intersectionOfTwoArray.intersect(e, f));
    }
}
