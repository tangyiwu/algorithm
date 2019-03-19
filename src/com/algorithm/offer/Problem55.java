package com.algorithm.offer;

import com.algorithm.model.TreeNode;

public class Problem55 {
    public int getTreeDepth(TreeNode tree) {
        return getDepth(tree, 0);
    }

    private int getDepth(TreeNode tree, int prevDepth) {
        if (tree == null) {
            return prevDepth;
        }
        return Math.max(getDepth(tree.left, prevDepth + 1), getDepth(tree.right, prevDepth + 1));
    }

    public boolean isBalanceTree(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        return Math.abs(getTreeDepth(tree.left) - getTreeDepth(tree.right)) <= 1
                && isBalanceTree(tree.left) && isBalanceTree(tree.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Problem55 problem55 = new Problem55();
        System.out.println(problem55.getTreeDepth(node1));
        System.out.println(problem55.isBalanceTree(node1));
    }
}
