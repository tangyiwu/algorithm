package com.algorithm.leetcode.easy;

/**
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class LeetCode53_MaxmumSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            res = Math.max(curSum, res);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return binarySearchMaxSum(nums, 0, nums.length - 1);
    }

    private int binarySearchMaxSum(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int middle = left + (right - left) / 2;
        int leftMaxSum = binarySearchMaxSum(nums, left, middle - 1);
        int rightMaxSum = binarySearchMaxSum(nums, middle + 1, right);
        int middleMaxSum = nums[middle];
        int t = middleMaxSum;
        for (int i = middle - 1; i >= left; i--) {
            t += nums[i];
            middleMaxSum = Math.max(middleMaxSum, t);
        }
        t = middleMaxSum;
        for (int i = middle + 1; i <= right; i++) {
            t += nums[i];
            middleMaxSum = Math.max(middleMaxSum, t);
        }
        return Math.max(middleMaxSum, Math.max(leftMaxSum, rightMaxSum));
    }

    public static void main(String[] args) {
        LeetCode53_MaxmumSubArray maxmumSubArray = new LeetCode53_MaxmumSubArray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxmumSubArray.maxSubArray(a));
        System.out.println(maxmumSubArray.maxSubArray2(a));
    }
}
