package com.algorithm.leetcode.easy;

/**
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class LeetCode204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                cnt++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode204_CountPrimes countPrimes = new LeetCode204_CountPrimes();
        System.out.println(countPrimes.countPrimes(1));
        System.out.println(countPrimes.countPrimes(2));
        System.out.println(countPrimes.countPrimes(3));
        System.out.println(countPrimes.countPrimes(4));
        System.out.println(countPrimes.countPrimes(5));
        System.out.println(countPrimes.countPrimes(6));
        System.out.println(countPrimes.countPrimes(10));
        System.out.println(countPrimes.countPrimes(100));
        System.out.println(countPrimes.countPrimes(1000));
        System.out.println(countPrimes.countPrimes(10000));
        System.out.println(countPrimes.countPrimes(100000));
    }
}
