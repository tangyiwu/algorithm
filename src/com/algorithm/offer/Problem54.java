package com.algorithm.offer;

import com.algorithm.model.TreeNode;

/**
 * 二叉查找树的第 K 个结点
 */
public class Problem54 {
    int cnt = 0;
    TreeNode e;

    public TreeNode findK(TreeNode tree, int k) {
        inOrder(tree, k);
        return e;
    }

    private void inOrder(TreeNode tree, int k) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left, k);
        cnt++;
        if (cnt == k) {
            e = tree;
            return;
        }
        inOrder(tree.right, k);
    }

    public static void main(String[] args) {

    }
}
