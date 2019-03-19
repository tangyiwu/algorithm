package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

///**
// *   5
// * 2   13
// */
//[0,-1,2,-3,null,null,4][6,5,6,2,null,null,4]
//      0                       6
//   -1    2        =>      5       6
//  -3       4          2               4
//
//
public class LeetCode538ConvertBSTtoGreaterTree {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = sum(root);
        inOrder(root);
        return root;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + root.val + sum(root.right);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        int tmp = root.val;
        root.val = sum;
        sum -= tmp;
        inOrder(root.right);
    }
}
