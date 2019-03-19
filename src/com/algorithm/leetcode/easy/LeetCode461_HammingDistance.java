package com.algorithm.leetcode.easy;

/**
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * 1   (0 0 0 1)
 * 3   (0 0 1 1)
 */
public class LeetCode461_HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x == y) {
            return 0;
        }
        int cnt = 0;
        int z = x ^ y;
        while (z > 0) {
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode461_HammingDistance hammingDistance = new LeetCode461_HammingDistance();
        System.out.println(hammingDistance.hammingDistance(4, 1));
        System.out.println(hammingDistance.hammingDistance(3, 1));
    }
}
