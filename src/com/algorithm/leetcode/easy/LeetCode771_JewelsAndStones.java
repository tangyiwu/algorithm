package com.algorithm.leetcode.easy;

public class LeetCode771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() <= 0 || S == null || S.length() <= 0) {
            return 0;
        }
        int[] a = new int[128];
        for (int i = 0; i < J.length(); i++) {
            a[J.charAt(i)]++;
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (a[S.charAt(i)] > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
