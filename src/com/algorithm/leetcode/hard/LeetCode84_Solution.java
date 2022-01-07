package com.algorithm.leetcode.hard;

public class LeetCode84_Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int h, s;
        for (int i = 0; i < n; i++) {
            h = heights[i];
            int left = i, right = i;
            while (left >= 0) {
                if (heights[left] >= h) {
                    left--;
                    continue;
                }
                break;
            }
            while (right < n) {
                if (heights[right] >= h) {
                    right++;
                    continue;
                }
                break;
            }
            s = (right - left - 1) * h;
            max = Math.max(max, s);
        }
        return max;
    }

    /**
     * 时间复杂度：O(n^2)
     */
    public int solution1(int[] heights) {
        int max = 0;
        int n = heights.length;
        int h, s;
        for (int i = 0; i < n; i++) {
            h = heights[i];
            int left = i, right = i;
            while (left >= 0) {
                if (heights[left] >= h) {
                    left--;
                    continue;
                }
                break;
            }
            while (right < n) {
                if (heights[right] >= h) {
                    right++;
                    continue;
                }
                break;
            }
            s = (right - left - 1) * h;
            max = Math.max(max, s);
        }
        return max;
    }
}
