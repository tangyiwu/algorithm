package com.algorithm.leetcode.medium;

import com.algorithm.model.TreeNode;

import java.util.Stack;

public class LeetCode230_KthSmallest {
    private int cnt;
    private int target;

    /**
     * 中序遍历实现
     */
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        inOrder(root, k);
        return target;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            target = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    /**
     * 非递归实现
     */
    private int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            k--;
            if (k == 0) {
                return pop.val;
            }
            if (pop.right != null) {
                stack.push(pop.right);
                root = pop.right;
            }
        }
        return -1;
    }
}
