package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

import java.util.LinkedList;

/**
 * 判断平衡二叉树
 */
public class LeetCode110_BalancedBinaryTree {
    private LinkedList<TreeNode> queue = new LinkedList<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        queue.clear();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.remove();
                size--;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
