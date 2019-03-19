package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeInner(p, q);
    }

    private boolean isSameTreeInner(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTreeInner(p.left, q.left) && isSameTreeInner(p.right, q.right);
    }
}
