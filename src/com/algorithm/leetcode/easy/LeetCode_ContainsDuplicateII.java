package com.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int min = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                min = Math.min(min, i - map.get(nums[i]));
            }
            map.put(nums[i], i);
        }
        return min != nums.length && min <= k;
    }
}
