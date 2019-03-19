package com.algorithm.offer;

import com.algorithm.model.TreeNode;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * preorder = [3,9,20,15,7]
 * inorder =  [9,3,15,20,7]
 */
public class Problem7 {
    public TreeNode rebuildTree(int[] a, int left, int right) {
        if (a == null || a.length <= 0 || left > right) {
            return null;
        }
        return null;
    }
}
