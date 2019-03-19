package com.algorithm.offer;

import com.algorithm.model.TreeNode;

/**
 * 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Problem36 {
    private TreeNode head;
    private TreeNode prev;

    public TreeNode binaryTree2Link(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        tree.left = prev;
        if (prev != null) {
            prev.right = tree;
        }
        prev = tree;
        if (head == null) {
            head = tree;
        }
        inOrder(tree.right);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        Problem36 problem36 = new Problem36();
        TreeNode link = problem36.binaryTree2Link(node0);
        boolean right = true;
        while (link != null) {
            System.out.print(link.val + " ");
            if (right) {
                if (link.right == null) {
                    right = false;
                } else {
                    link = link.right;
                }
            } else {
                link = link.left;
            }
        }
    }
}
