package com.algorithm.offer;

import com.algorithm.model.TreeNode;
import com.algorithm.utils.TreeUtil;

/**
 * 二叉树的镜像
 */
public class Problem27 {
    public TreeNode mirrorTree(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        TreeNode left = tree.left;
        TreeNode right = tree.right;
        if (left != null) {
            tree.right = mirrorTree(left);
        }
        if (right != null) {
            tree.left = mirrorTree(right);
        }
        return tree;
    }

    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();
        TreeNode mirrorTree = problem27.mirrorTree(TreeUtil.buildDemoTree());
        TreeUtil.preOrder(mirrorTree);

    }
}
