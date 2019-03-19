package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode543DiameterOfBinaryTree {
    int maxPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        preOrder(root);
        return maxPath;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        maxPath = Math.max(maxPath, lengthToBottom(root.left) + lengthToBottom(root.right));
        preOrder(root.left);
        preOrder(root.right);
    }

    private int lengthToBottom(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(lengthToBottom(root.left), lengthToBottom(root.right));
    }
}
