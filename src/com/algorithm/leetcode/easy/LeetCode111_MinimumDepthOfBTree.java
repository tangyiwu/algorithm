package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode111_MinimumDepthOfBTree {
    int minDepth = 0;

    public int minDepth(TreeNode root) {
        minDepth(root, 1);
        return minDepth;
    }

    private void minDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (minDepth == 0) {
                minDepth = depth;
            } else {
                minDepth = Math.min(minDepth, depth);
            }
        } else {
            minDepth(root.left, depth + 1);
            minDepth(root.right, depth + 1);
        }
    }
}
