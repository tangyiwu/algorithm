package com.algorithm.leetcode.easy;

public class LeetCode70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int t = a;
            a = b;
            b = t + a;
        }
        return b;
    }

    public static void main(String[] args) {
        LeetCode70_ClimbingStairs climbingStairs = new LeetCode70_ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(1));
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
    }
}
