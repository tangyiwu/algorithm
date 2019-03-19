package com.algorithm.leetcode.easy;

import com.algorithm.utils.ArrayUtil;

import java.util.HashMap;

public class LeetCode1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = new int[2];
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode1_TwoSum twoSum = new LeetCode1_TwoSum();
        int[] a = {2, 7, 11, 15};
        ArrayUtil.printArray(twoSum.twoSum(a, 9));
    }
}
