package com.algorithm.offer;

import com.algorithm.model.TreeNode;

/**
 * 树中两个节点的最低公共祖先
 */
public class Problem68 {
    private TreeNode solution;

    public TreeNode findNearestAncestor(TreeNode tree, TreeNode a, TreeNode b) {
        if (tree == null) {
            return null;
        }
        prevOrder(tree, a, b);
        return solution;
    }

    private void prevOrder(TreeNode tree, TreeNode a, TreeNode b) {
        if (tree == null) {
            return;
        }
        if (haveNode(tree.left, a) && haveNode(tree.right, b)) {
            solution = tree;
            return;
        }
        prevOrder(tree.left, a, b);
        prevOrder(tree.right, a, b);
    }

    private boolean haveNode(TreeNode tree, TreeNode child) {
        if (tree == null) {
            return false;
        }
        if (tree == child) {
            return true;
        }
        return haveNode(tree.left, child) || haveNode(tree.right, child);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        node5.left = node6;
        node5.right = node7;
        Problem68 problem68 = new Problem68();
        TreeNode common = problem68.findNearestAncestor(node4, node1, node3);
        System.out.println(common.val);
    }
}
