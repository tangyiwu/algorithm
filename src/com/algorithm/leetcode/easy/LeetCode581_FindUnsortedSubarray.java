package com.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class LeetCode581_FindUnsortedSubarray {
    // Bad solution
//    public int findUnsortedSubarray(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        int i = -1;
//        int j = nums.length;
//        boolean searchMin = true;
//        for (int k = 0; k < nums.length - 1; k++) {
//            for (int p = k + 1; p < nums.length; p++) {
//                if (nums[k] > nums[p]) {
//                    searchMin = false;
//                    break;
//                }
//            }
//            if (!searchMin) {
//                break;
//            }
//            i++;
//        }
//        boolean searchMax = true;
//        for (int k = nums.length - 1; k > i; k--) {
//            for (int p = k - 1; p >= 0; p--) {
//                if (nums[k] < nums[p]) {
//                    searchMax = false;
//                    break;
//                }
//            }
//            if (!searchMax) {
//                break;
//            }
//            j--;
//        }
//        if (j > i) {
//            return j - i - 1;
//        }
//        return 0;
//    }

    // [1,2,3,4]
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int notMoved = 0;
        int m = 0;
        int n = nums.length - 1;
        while (m < nums.length && nums[m] == copy[m]) {
            m++;
            notMoved++;
        }
        while (n > m && nums[n] == copy[n]) {
            n--;
            notMoved++;
        }
        return nums.length - notMoved;
    }

    public static void main(String[] args) {
        int[] a = {2, 6, 4, 8, 10, 9, 15};
        LeetCode581_FindUnsortedSubarray findUnsortedSubarray = new LeetCode581_FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(a));
        int[] b = {3, 2, 3, 2, 4};
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(b));
    }
}
