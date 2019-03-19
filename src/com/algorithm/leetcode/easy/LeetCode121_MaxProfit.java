package com.algorithm.leetcode.easy;

public class LeetCode121_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};
        LeetCode121_MaxProfit maxProfit = new LeetCode121_MaxProfit();
        System.out.println(maxProfit.maxProfit(a));
        System.out.println(maxProfit.maxProfit(b));
    }
}
