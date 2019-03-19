package com.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode217_ContainsDuplicate {
    /**
     * Input: [1,2,3,1]
     * Output: true
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }
}
