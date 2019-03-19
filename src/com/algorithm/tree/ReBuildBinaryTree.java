package com.algorithm.tree;

import com.algorithm.model.TreeNode;
import com.algorithm.utils.TreeUtil;

import java.util.HashMap;
import java.util.Map;

public class ReBuildBinaryTree {
    private Map<Integer, Integer> indexOfInOrders = new HashMap<>();

    public TreeNode reBuildBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexOfInOrders.put(in[i], i);
        }
        return reBuildBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reBuildBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexOfInOrders.get(root.val);
        int leftSize = inIndex - inL;
        root.left = reBuildBinaryTree(pre, preL + 1, preL + leftSize, inL);
        root.right = reBuildBinaryTree(pre, preL + leftSize + 1, preR, inL + leftSize + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ReBuildBinaryTree reBuildBinaryTree = new ReBuildBinaryTree();
        TreeNode tree = reBuildBinaryTree.reBuildBinaryTree(preorder, inorder);
        TreeUtil.printTree(tree);
    }
}
