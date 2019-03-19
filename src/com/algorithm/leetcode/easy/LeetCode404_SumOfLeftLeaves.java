package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode404_SumOfLeftLeaves {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftLeaves(root, false);
        return sum;
    }

    private void sumLeftLeaves(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeftChild) {
            sum += root.val;
            return;
        }
        if (root.left != null) {
            sumLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            sumLeftLeaves(root.right, false);
        }
    }
}
