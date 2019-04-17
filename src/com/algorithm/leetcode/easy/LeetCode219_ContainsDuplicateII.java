package com.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int distance = i - map.get(nums[i]);
                if (distance <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * best
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode219_ContainsDuplicateII containsDuplicateII = new LeetCode219_ContainsDuplicateII();
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 0, 1, 1};
        int[] c = {1, 2, 3, 1, 2, 3};
        System.out.println(containsDuplicateII.containsNearbyDuplicate(a, 3));
        System.out.println(containsDuplicateII.containsNearbyDuplicate2(a, 3));
        System.out.println(containsDuplicateII.containsNearbyDuplicate(b, 1));
        System.out.println(containsDuplicateII.containsNearbyDuplicate2(b, 1));
        System.out.println(containsDuplicateII.containsNearbyDuplicate(c, 2));
        System.out.println(containsDuplicateII.containsNearbyDuplicate2(c, 2));
    }
}
