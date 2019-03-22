package com.algorithm.leetcode.medium;

import java.util.TreeSet;

public class LeetCode220_ContainsDuplicateIII {
    /**
     * 利用滑动窗口思想解决
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long e = nums[i];
            Long floor = treeSet.floor(e + t);
            Long ceil = treeSet.ceiling(e - t);
            if ((floor != null && Math.abs(floor - e) <= t) || (ceil != null && Math.abs(e - ceil) <= t)) {
                return true;
            }
            treeSet.add(e);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode220_ContainsDuplicateIII containsDuplicateIII = new LeetCode220_ContainsDuplicateIII();
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 0, 1, 1};
        int[] c = {1, 5, 9, 1, 5, 9};
        int[] d = {-2147483648, -2147483647};
        int[] e = {2147483647, -2147483647};
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(a, 3, 0));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(b, 1, 2));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(c, 2, 3));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(d, 3, 3));
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(e, 1, 2147483647));
    }
}
