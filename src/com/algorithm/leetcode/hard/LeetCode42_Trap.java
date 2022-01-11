package com.algorithm.leetcode.hard;

public class LeetCode42_Trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        rightMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        int tmp;
        for (int i = 0; i < height.length; i++) {
            tmp = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (tmp > 0) {
                sum += tmp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode42_Trap demo = new LeetCode42_Trap();
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(demo.trap(a));
    }
}
