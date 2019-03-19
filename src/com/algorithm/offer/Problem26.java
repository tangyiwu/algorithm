package com.algorithm.offer;

import com.algorithm.model.TreeNode;

/**
 * 树的子结构
 */
public class Problem26 {
    public boolean hasSubTree(TreeNode tree, TreeNode subTree) {
        if (tree == null || subTree == null) {
            return false;
        }
        return isSubTreeOfRoot(tree, subTree) || isSubTreeOfRoot(tree.left, subTree) || isSubTreeOfRoot(tree.right, subTree);
    }

    private boolean isSubTreeOfRoot(TreeNode root, TreeNode subTree) {
        if (subTree == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != subTree.val) {
            return false;
        }
        return isSubTreeOfRoot(root.left, subTree.left) && isSubTreeOfRoot(root.right, subTree.right);
    }

    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        TreeNode tree0 = new TreeNode(8);
        TreeNode tree1 = new TreeNode(8);
        TreeNode tree2 = new TreeNode(7);
        TreeNode tree3 = new TreeNode(9);
        TreeNode tree4 = new TreeNode(2);
        TreeNode tree5 = new TreeNode(1);
        TreeNode tree6 = new TreeNode(1);
        tree0.left = tree1;
        tree0.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;
        tree2.right = tree6;

        TreeNode subTree0 = new TreeNode(8);
        TreeNode subTree1 = new TreeNode(9);
        TreeNode subTree2 = new TreeNode(2);
        subTree0.left = subTree1;
        subTree0.right = subTree2;
        System.out.println(problem26.hasSubTree(tree0, subTree0));
    }
}
