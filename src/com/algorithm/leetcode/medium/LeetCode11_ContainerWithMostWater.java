package com.algorithm.leetcode.medium;

public class LeetCode11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int area;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j > i; j--) {
                area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        LeetCode11_ContainerWithMostWater containerWithMostWater = new LeetCode11_ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(nums));
        System.out.println(containerWithMostWater.maxArea2(nums));
    }
}
