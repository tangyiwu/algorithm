package com.algorithm.leetcode.medium;

import com.algorithm.model.TreeNode;

public class LeetCode114_Solution {
    TreeNode pre;

    public void flatten(TreeNode root) {
        pre = null;
        traversal(root);
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        traversal(root.left);
        root.right = pre;
        pre = root;
        root.left = null;
    }

    public static void main(String[] args) {
        //     5
        //   4   6
        //      3 7
        LeetCode114_Solution solution = new LeetCode114_Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
        System.out.println(root.val);
    }
}
