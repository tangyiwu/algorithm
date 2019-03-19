package com.algorithm.leetcode.easy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        int max = nums[0];
        minQueue.add(nums[0]);
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                max = Math.max(max, nums[i]);
                minQueue.add(nums[i]);
                set.add(nums[i]);
                if (minQueue.size() > 3) {
                    minQueue.poll();
                }
            }
        }
        return minQueue.size() == 3 ? minQueue.peek() : max;
    }

    public static void main(String[] args) {
        LeetCode414_ThirdMaximumNumber thirdMaximumNumber = new LeetCode414_ThirdMaximumNumber();
        int[] a = {3, 2, 1, 4, 5, 9, 8, 7};
        int[] b = {1, 2};
        int[] c = {2, 2, 3, 1};
        int[] d = {1, 2, 2};
        System.out.println(thirdMaximumNumber.thirdMax(a));
        System.out.println(thirdMaximumNumber.thirdMax(b));
        System.out.println(thirdMaximumNumber.thirdMax(c));
        System.out.println(thirdMaximumNumber.thirdMax(d));
    }
}
