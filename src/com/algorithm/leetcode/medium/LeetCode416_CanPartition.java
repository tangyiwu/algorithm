package com.algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class LeetCode416_CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int j = 0; j <= target; j++) {
            dp[0][j] = nums[0] == j;
        }
        if(dp[0][target]) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i][j] || j < nums[i]) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j - nums[i]];
                if (dp[i][j] && j == target) {
                    return true;
                }
            }
        }
        return dp[nums.length-1][target];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        LeetCode416_CanPartition solution = new LeetCode416_CanPartition();
        System.out.println(solution.canPartition(a));
    }
}
