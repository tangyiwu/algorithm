package com.algorithm.leetcode.easy;

/**
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class LeetCode198_HouseRobber {
    // 回溯方法不是一个很好的选择，当数组很多时，执行时间很长
//    int maxValue;
//
//    /**
//     * [2,1,1,2] => 4
//     */
//    public int rob(int[] nums) {
//        maxValue = 0;
//        rob(nums, 0, 0);
//        return maxValue;
//    }
//
//    private void rob(int[] nums, int cur, int curValue) {
//        if (cur >= nums.length) {
//            maxValue = Math.max(maxValue, curValue);
//            return;
//        }
//        rob(nums, cur + 2, curValue + nums[cur]); // rob cur
//        rob(nums, cur + 1, curValue); // skip cur
//    }

//    public int rob(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, maxRobValue(nums, i));
//        }
//        return max;
//    }
//
//    private int maxRobValue(int[] nums, int lastRob) {
//        if (lastRob < 2) {
//            return nums[lastRob];
//        }
//        int max = 0;
//        for (int i = 0; i <= lastRob - 2; i++) {
//            max = Math.max(max, nums[lastRob] + maxRobValue(nums, i));
//        }
//        return max;
//    }

    public int rob(int[] nums) {
        return rob(nums, nums.length);
    }

    private int rob(int[] nums, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = rob(nums, 1);
        int b = rob(nums, 2);
        for (int i = 3; i <= n; i++) {
            int iRob = nums[i - 1] + a;
            int iSafe = b;
            a = b;
            b = Math.max(iRob, iSafe);
        }
        return b;
    }

    /**
     * 动态规划实现
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};//4
        int[] b = {2, 7, 9, 3, 1};//12
        //4173
        int[] c = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        LeetCode198_HouseRobber houseRobber = new LeetCode198_HouseRobber();
        System.out.println(houseRobber.rob(a));
        System.out.println(houseRobber.rob(b));
        System.out.println(houseRobber.rob(c));
        System.out.println(houseRobber.rob2(a));
        System.out.println(houseRobber.rob2(b));
        System.out.println(houseRobber.rob2(c));
    }
}
