package com.algorithm.utils;

import com.algorithm.model.TreeNode;

public class TreeUtil {
    //
//    8
//  5   10
// 3 6 9 12
//
    public static TreeNode buildDemoTree() {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(12);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }

    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + " ");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    public static void printTree(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            System.out.println(tree.val + "\t的左节点是\t" + tree.left.val);
        }
        if (tree.right != null) {
            System.out.println(tree.val + "\t的右节点是\t" + tree.right.val);
        }
        printTree(tree.left);
        printTree(tree.right);
    }
}
