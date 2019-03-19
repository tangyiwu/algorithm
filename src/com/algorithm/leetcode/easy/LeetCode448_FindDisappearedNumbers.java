package com.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class LeetCode448_FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i] - 1]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
