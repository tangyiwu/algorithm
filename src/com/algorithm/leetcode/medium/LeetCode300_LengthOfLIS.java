package com.algorithm.leetcode.medium;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class LeetCode300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int len = 0;
            while (j >= 0) {
                if (nums[j] < nums[i] && dp[j] > len) {
                    len = dp[j];
                }
                j--;
            }
            if (len > 0) {
                dp[i] = len + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode300_LengthOfLIS demo = new LeetCode300_LengthOfLIS();
        int[] a = {0,1,0,3,2,3};
        System.out.println(demo.lengthOfLIS(a));
    }
}
