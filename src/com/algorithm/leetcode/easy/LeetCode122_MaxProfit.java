package com.algorithm.leetcode.easy;

public class LeetCode122_MaxProfit {
//    private int maxProfit;
//
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length <= 1) {
//            return 0;
//        }
//        maxProfit = 0;
//        operation(prices, 0, 0, false);
//        return maxProfit;
//    }
//
//    private void operation(int[] prices, int day, int asset, boolean hasStock) {
//        maxProfit = Math.max(maxProfit, asset);
//        if (day >= prices.length) {
//            return;
//        }
//        if (!hasStock) {
//            operation(prices, day + 1, asset - prices[day], true);// buy stock
//            operation(prices, day + 1, asset, false); // skip
//        } else {
//            operation(prices, day + 1, asset + prices[day], false); // sale stock
//            operation(prices, day + 1, asset, true);// skip
//        }
//    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LeetCode122_MaxProfit maxProfit = new LeetCode122_MaxProfit();
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println(maxProfit.maxProfit(a));
        System.out.println(maxProfit.maxProfit(b));
    }
}
