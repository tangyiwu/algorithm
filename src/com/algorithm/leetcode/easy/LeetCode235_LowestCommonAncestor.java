package com.algorithm.leetcode.easy;

import com.algorithm.model.TreeNode;

public class LeetCode235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) {
            return root;
        }
        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
