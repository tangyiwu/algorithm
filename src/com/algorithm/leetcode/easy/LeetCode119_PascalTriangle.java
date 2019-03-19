package com.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119_PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre.clear();
            pre.addAll(cur);
            cur.clear();
        }
        return pre;
    }
}
